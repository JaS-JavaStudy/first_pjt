import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BaseballGame {

    // 숫자 리스트를 생성하여 4자리 서로 다른 숫자를 만듦
    public static List<Integer> generateRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, 4);
    }

    // 숫자 입력을 받아 리스트로 변환
    public static List<Integer> inputNumber(String input) {
        List<Integer> guess = new ArrayList<>();
        for (char c : input.toCharArray()) {
            guess.add(Character.getNumericValue(c));
        }
        return guess;
    }

    // 스트라이크와 볼을 계산
    public static int[] calculateStrikeAndBall(List<Integer> answer, List<Integer> guess) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 4; i++) {
            if (answer.get(i).equals(guess.get(i))) {
                strike++;
            } else if (answer.contains(guess.get(i))) {
                ball++;
            }
        }
        return new int[]{strike, ball};
    }

    // 가능한 모든 4자리 숫자 조합을 생성 (서로 다른 숫자로 구성)
    public static List<List<Integer>> generateAllCombinations() {
        List<List<Integer>> allCombinations = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == i) continue;
                for (int k = 0; k < 10; k++) {
                    if (k == i || k == j) continue;
                    for (int l = 0; l < 10; l++) {
                        if (l == i || l == j || l == k) continue;
                        List<Integer> combination = new ArrayList<>();
                        combination.add(i);
                        combination.add(j);
                        combination.add(k);
                        combination.add(l);
                        allCombinations.add(combination);
                    }
                }
            }
        }
        return allCombinations;
    }

    // 가능한 후보군에서 필터링: 스트라이크와 볼 수가 같은 후보만 남김
    public static List<List<Integer>> filterCandidates(List<List<Integer>> candidates, List<Integer> guess, int[] result) {
        List<List<Integer>> newCandidates = new ArrayList<>();
        for (List<Integer> candidate : candidates) {
            int[] tempResult = calculateStrikeAndBall(candidate, guess);
            if (tempResult[0] == result[0] && tempResult[1] == result[1]) {
                newCandidates.add(candidate);
            }
        }
        return newCandidates;
    }

    // 게임을 시작하는 메소드
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 유저와 컴퓨터의 4자리 숫자 생성
        List<Integer> userNumber = generateRandomNumber();
        List<Integer> computerNumber = generateRandomNumber();

        System.out.println("숫자 야구 게임을 시작합니다!");
        System.out.println("서로 다른 4자리 숫자를 생각해주세요.\n");

        int userAttempts = 0;
        int computerAttempts = 0;
        boolean userCorrect = false;
        boolean computerCorrect = false;

        // 컴퓨터의 가능한 모든 후보 숫자 리스트
        List<List<Integer>> computerCandidates = generateAllCombinations();

        while (!userCorrect || !computerCorrect) {
            // 유저 차례
            if (!userCorrect) {
                System.out.print("당신의 추측 (4자리 숫자): ");
                String userInput = scanner.nextLine();
                List<Integer> userGuess = inputNumber(userInput);
                userAttempts++;
                int[] userResult = calculateStrikeAndBall(computerNumber, userGuess);
                System.out.println(userResult[0] + " 스트라이크, " + userResult[1] + " 볼");

                if (userResult[0] == 4) {
                    System.out.println("축하합니다! 당신이 맞췄습니다.");
                    userCorrect = true;
                }
            }

            // 컴퓨터 차례
            if (!computerCorrect) {
                // 가능한 후보 중 첫 번째 후보를 선택
                List<Integer> computerGuess = computerCandidates.get(0);
                computerAttempts++;
                System.out.println("\n컴퓨터의 추측: " + computerGuess);
                int[] computerResult = calculateStrikeAndBall(userNumber, computerGuess);
                System.out.println(computerResult[0] + " 스트라이크, " + computerResult[1] + " 볼");

                if (computerResult[0] == 4) {
                    System.out.println("컴퓨터가 정답을 맞췄습니다!");
                    computerCorrect = true;
                } else {
                    // 추측 결과를 바탕으로 가능한 후보들을 필터링
                    computerCandidates = filterCandidates(computerCandidates, computerGuess, computerResult);
                }
            }

            System.out.println();
        }

        // 승자 결정
        if (userAttempts < computerAttempts) {
            System.out.println("당신이 승리했습니다! (" + userAttempts + "번의 추측)");
        } else if (computerAttempts < userAttempts) {
            System.out.println("컴퓨터가 승리했습니다! (" + computerAttempts + "번의 추측)");
        } else {
            System.out.println("비겼습니다! (" + userAttempts + "번의 추측)");
        }

        scanner.close();
    }
}
