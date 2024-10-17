import java.util.Random;
import java.util.Scanner;

public class Prime_Number_Game_Ver2 {
    private int score; // ����
    private int difficulty; // ���̵�
    private int[] primes; // �Ҽ� �迭

    // ������
    public Prime_Number_Game_Ver2(int difficulty) {
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

    // �ð� ������ �ΰ� �Է��� �޴� �޼��� G������
    private Integer getInputWithTimeout(int timeoutInSeconds) {
        final Integer[] answer = new Integer[1]; // �迭�� ����Ͽ� ������ ���� �ذ�
        Thread inputThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            answer[0] = scanner.nextInt();
        });

        inputThread.start();

        try {
            inputThread.join(timeoutInSeconds * 1000); // �ð� ����
            if (inputThread.isAlive()) {
                inputThread.interrupt(); // Ÿ�Ӿƿ� �� �Է� ������ ����
                System.out.println("�ð� �ʰ�! �Է��� ���� ���߽��ϴ�.");
                return null; // �ð� �ʰ�
            }
        } catch (InterruptedException e) {
            return null; // �ٸ� ���� �߻�
        }

        return answer[0]; // �Էµ� �� ��ȯ
    }

    // ���� ���� �޼���
    public void startGame() {
        System.out.println("�Ҽ� �ǵ� ������ �����մϴ�!");

        while (true) {
            // ���� ����
            int problem = randomGame();
            System.out.println("���� " + score);
            System.out.println("������ ����: " + problem);
            System.out.println("�Ҽ��� 1, �ƴϸ� 0�� �Է��� �ּ���:");

            Integer answer = getInputWithTimeout(3); // 5�� �ð� ����
            if (answer == null) {
                break; // �ð� �ʰ��� ����
            }

            boolean correct = (answer == 1 && primes[problem] != 0) || (answer == 0 && primes[problem] == 0);

            // ������ �ƴϸ� Ż��
            if (!correct) {
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

        Prime_Number_Game_Ver2 game = new Prime_Number_Game_Ver2(difficulty);
        game.startGame();
    }
}
