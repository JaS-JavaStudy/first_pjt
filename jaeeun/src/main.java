import java.util.Arrays;
import java.util.Scanner;

public class main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("사용자의 수를 입력해주세요: ");
        int playerNum = sc.nextInt();
        sc.nextLine();

        String[] playerList = new String[playerNum];

        System.out.println();
        System.out.println("플레이어명은 영어로만 입력해주세요!");
        for (int i = 0; i < playerNum; i++) {
            System.out.print((i + 1) + "번째 플레이어: ");
            playerList[i] = sc.nextLine();
        }

        int[] points = new int[playerNum];
        String before = "";
        int turn = 0;
        while (true) {
            if (turn == playerNum) {
                turn = 0;
            }

            System.out.println();
            System.out.print(playerList[turn] +"(" + points[turn] + ")" + " 님의 차례: ");
            String word = sc.nextLine();
            if (before.equals("")) {
                before = word;
                points[turn] += word.length();
            } else {
                int before_len = before.length();
                if (word.charAt(0) == (before.charAt(before_len - 1))) {
                    before = word;
                    points[turn] += word.length();
                } else {
                    System.out.println(playerList[turn] + "님 오답을 입력하셨습니다!");
                    points[turn] -= 10;
                    break;
                }
            }
            turn++;
        }
        System.out.println();
        int max_point = 0;
        int max_idx = 0;
        for (int i = 0; i < playerNum; i++) {
            if (points[i] >= max_point) {
                max_point = points[i];
                max_idx = i;
            }
            System.out.println(playerList[i] + "님의 점수는 " + points[i] + "점 입니다");
        }

        System.out.println(playerList[max_idx] + "님의 승리!!!!");
    }
}
