import java.util.Scanner;

public class main {
    static Scanner sc  = new Scanner(System.in);
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

//        while (true)
        
    }
}
