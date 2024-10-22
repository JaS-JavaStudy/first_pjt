//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class main {
    static Scanner sc;
    static String before;
    static int turn;

    public main() {
    }

    public static void main(String[] args) {
        System.out.print("사용자의 수를 입력해주세요: ");
        int playerNum = sc.nextInt();
        sc.nextLine();
        int[] points = new int[playerNum];
        String[] playerList = setPlayer(playerNum);

        while(true) {
            if (turn == playerNum) {
                turn = 0;
            }

            System.out.println();
            System.out.print(playerList[turn] + "(" + points[turn] + ") 님의 차례: ");
            String word = sc.nextLine();
            int var10001;
            if (before.equals("")) {
                GetApi api = new GetApi();
                if (!api.isWordExist(word)) {
                    var10001 = turn;
                    points[var10001] -= 10;
                    break;
                }

                before = word;
                var10001 = turn;
                points[var10001] += word.length();
            } else {
                boolean isVaild = validCheck(word);
                if (!isVaild) {
                    System.out.println(playerList[turn] + "님 오답을 입력하셨습니다!");
                    var10001 = turn;
                    points[var10001] -= 10;
                    break;
                }

                before = word;
                var10001 = turn;
                points[var10001] += word.length();
            }

            ++turn;
        }

        System.out.println();
        findWinner(playerNum, playerList, points);
    }

    private static String[] setPlayer(int playerNum) {
        String[] playerList = new String[playerNum];
        System.out.println();
        System.out.println("플레이어명은 영어로만 입력해주세요!");

        for(int i = 0; i < playerNum; ++i) {
            System.out.print(i + 1 + "번째 플레이어: ");
            playerList[i] = sc.nextLine();
        }

        return playerList;
    }

    private static boolean validCheck(String word) {
        int before_len = before.length();
        GetApi myword = new GetApi();
        return word.charAt(0) == before.charAt(before_len - 1) && myword.isWordExist(word);
    }

    private static void findWinner(int playerNum, String[] playerList, int[] points) {
        int max_point = 0;
        int max_idx = 0;

        for(int i = 0; i < playerNum; ++i) {
            if (points[i] >= max_point) {
                max_point = points[i];
                max_idx = i;
            }

            System.out.println(playerList[i] + "님의 점수는 " + points[i] + "점 입니다");
        }

        System.out.println(playerList[max_idx] + "님의 승리!!!!");
    }

    static {
        sc = new Scanner(System.in);
        before = "";
        turn = 0;
    }
}
