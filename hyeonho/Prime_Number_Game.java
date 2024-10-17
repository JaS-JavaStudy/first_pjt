import java.util.*;

public class Prime_Number_Game {
    private int score; // ����
    private int difficulty; // ���̵�
    private int[] primes; // �Ҽ� �迭

    // ������
    public Prime_Number_Game(int difficulty) {
        this.difficulty = difficulty;
        this.primes = calculatePrimes(difficulty);
        this.score = 0; // ���� �ʱ�ȭ
    }

    // ���� ���� �ֱ�
    private int randomGame() {
        Random random = new Random();
        return random.nextInt(difficulty);
    }

    // �Ҽ��� ����ϴ� �޼���
    private int[] calculatePrimes(int difficultyLevel) {
        int newDifficulty = difficultyLevel + 1;
        int[] arr = new int[newDifficulty];

        // �迭 ���� �Ҵ�
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

    
    
    
    
    // ���� ���� �޼���
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("�Ҽ� �ǵ� ������ �����մϴ�!");

        while (true) {
            // ���� ����
            int problem = randomGame();
            System.out.println("���� " + score);
            System.out.println("������ ����: " + problem);
            System.out.println("�Ҽ��� 1, �ƴϸ� 0�� �Է��� �ּ���:");
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
            
            // ������ �ƴϸ� Ż��
            if (correct == false) {
            	break;
            }

            // �����̸� ���� ����
            score++;
        }

        // ���
        System.out.println("����� ������ " + score + "���Դϴ�.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("���̵��� �Է��ϼ���: ");
        int difficulty = scanner.nextInt();

        Prime_Number_Game game = new Prime_Number_Game(difficulty);
        game.startGame();
    }
}
