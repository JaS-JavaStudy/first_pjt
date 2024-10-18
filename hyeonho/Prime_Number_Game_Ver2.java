import java.util.Random;
import java.util.Scanner;

public class Prime_Number_Game_Ver2 {
    private int score; // 점수
    private int difficulty; // 난이도
    private int[] primes; // 소수 배열

    // 생성자
    public Prime_Number_Game_Ver2(int difficulty) {
        this.difficulty = difficulty;
        this.primes = calculatePrimes(difficulty);
        this.score = 0; // 점수 초기화
    }

    // 랜덤 숫자 주기
    private int randomGame() {
        Random random = new Random();
        return random.nextInt(difficulty);
    }

    // 소수를 계산하는 메서드
    private int[] calculatePrimes(int difficultyLevel) {
        int newDifficulty = difficultyLevel + 1;
        int[] arr = new int[newDifficulty];

        // 배열 숫자 할당
        for (int i = 0; i < newDifficulty; i++) {
            arr[i] = i;
        }
        arr[0] = 0;
        arr[1] = 0;

        for (int i = 2; i * i < newDifficulty; i++) {
            if (arr[i] != 0) {
                for (int j = i * i; j < newDifficulty; j += i) {
                    arr[j] = 0;
                }
            }
        }

        return arr;
    }

    // 시간 제한을 두고 입력을 받는 메서드 G선생님
    private Integer getInputWithTimeout(int timeoutInSeconds) {
        final Integer[] answer = new Integer[1]; // 배열을 사용하여 스코프 문제 해결d
        Thread inputThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            answer[0] = scanner.nextInt();
        });

        inputThread.start();

        try {
            inputThread.join(timeoutInSeconds * 1000); // 시간 제한
            if (inputThread.isAlive()) {
                inputThread.interrupt(); // 타임아웃 시 입력 스레드 종료
                System.out.println("시간 초과! 🤣🤣🤣🤣");
                return null; // 시간 초과
            }
        } catch (InterruptedException e) {
            return null; // 다른 예외 발생
        }

        return answer[0]; // 입력된 값 반환
    }

    // 게임 시작 메서드
    public void startGame() {
        System.out.println("소수 판독 게임을 시작합니다!");

        while (true) {
            // 문제 출제
            int problem = randomGame();
            System.out.println("문제 " + score);
            System.out.println("출제된 숫자: " + problem);
            System.out.println("소수면 1, 아니면 0을 입력해 주세요:");

            Integer answer = getInputWithTimeout(3); // 3초 시간 제한
            if (answer == null) {
                break; // 시간 초과시 종료
            }

            boolean correct = (answer == 1 && primes[problem] != 0) || (answer == 0 && primes[problem] == 0);

            // 정답이 아니면 탈락
            if (!correct) {
                System.out.println("땡 😜😜😜");
                break;
            }

            // 정답이면 점수 증가
            score++;
        }

        // 출력
        System.out.println("당신의 점수는 " + score + "점입니다.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("난이도는 수의 범위입니다 ");
        System.out.print("난이도를 입력하세요: ");
        int difficulty = scanner.nextInt();

        Prime_Number_Game_Ver2 game = new Prime_Number_Game_Ver2(difficulty);
        game.startGame();
    }
}