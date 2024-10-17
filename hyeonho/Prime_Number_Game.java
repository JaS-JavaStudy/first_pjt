import java.util.*;

public class Prime_Number_Game {
    private int score; // 점수
    private int difficulty; // 난이도
    private int[] primes; // 소수 배열

    // 생성자
    public Prime_Number_Game(int difficulty) {
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

    
    
    
    
    // 게임 시작 메서드
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("소수 판독 게임을 시작합니다!");

        while (true) {
            // 문제 출제
            int problem = randomGame();
            System.out.println("문제 " + score);
            System.out.println("출제된 숫자: " + problem);
            System.out.println("소수면 1, 아니면 0을 입력해 주세요:");
            boolean correct = true;
            int answer = scanner.nextInt();
            if (answer == 0) {
            	if (primes[problem] != 0) {
            		correct = false;
            	}
            	
            }else{
            	if (primes[problem] == 0) {
            		correct = false;
            	}
            }
            
            // 정답이 아니면 탈락
            if (correct == false) {
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
        System.out.print("난이도를 입력하세요: ");
        int difficulty = scanner.nextInt();

        Prime_Number_Game game = new Prime_Number_Game(difficulty);
        game.startGame();
    }
}
