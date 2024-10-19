import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.print("닉네임 입력 : ");          // 닉네임 입력
        String userName = sc.nextLine();
        System.out.print("비밀번호 입력 : ");        // 비밀번호입력
        String password = sc.nextLine();
        User user = new User(userName);            // 유저 인스턴스 생성

        user.startuser();                           // 유저 정보 콘솔출력

        MakeFoodList foodManager = new MakeFoodList();  // 음식정보 인스턴스
        List<Food> foodList = foodManager.run();       // 음식정보 업로드 클래스 호출


        // 3. 프로그램 시작
        boolean continueGame = true;
        Random random = new Random();                   // 랜덤음식 뽑는 random 함수

        while (continueGame && user.score < user.limit_point) {     // 종료되지 않고 배안부름

            Food randomFood = foodList.get(random.nextInt(foodList.size()));    // 음식정보인스턴스로부터 하나뽑기


            hungry_namgi(randomFood);               // 뽑은 음식 콘솔에 보여주기

            String choice = sc.nextLine();          // 사용자 입력받기

            ConsoleUtils.clearConsole();            // 콘솔창 비우기 클래스 호출
            // 4. 음식 선택 여부 확인
            if (choice.equalsIgnoreCase("y")) {                     // y 입력시
                if (user.score + randomFood.score <= user.limit_point) {

                    user.addscore(randomFood.score);                            // user인스턴스 값 변경
                    user.addEatenFood(randomFood.img);

                    System.out.println("     " +randomFood.img + " 냠냠");        // 콘솔출력
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println(String.join(" ", user.eatenFoods));
                } else {
                    fullcry(user);                                              // static 매서드 호출
                    continueGame = false;                                       // 게임종료변수 false
                }
            } else {
                System.out.println(randomFood.img + "는 버려졌습니다.");           // n 입력시
                randomFood = foodList.get(random.nextInt(foodList.size()));
                System.out.print("더 먹을수 있어? yes or no: ");
                String continueChoice = sc.nextLine();
                if (!continueChoice.equalsIgnoreCase("yes")) {
                    continueGame = false;
                    user.startuser();
                    System.out.println("✨✨"+user.score+"점 획득 ✨✨");
                }
            }

        }
        System.out.println("fin");
    }
    static void fullcry(User user){
        user.startuser();
        System.out.println("    탈락탈락탈락");
        for (int i = 0; i < user.eatenFoods.size()+3; i++) {
            System.out.print("⬜");
        }
        System.out.println();
        System.out.println("⬜"+String.join(" ", user.eatenFoods)+"⬜");
        for (int i = 0; i < user.eatenFoods.size()+3; i++) {
            System.out.print("⬜");
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println("🥵 배불러 ㅠㅠ 🥵");
        }
    }
    static void hungry_namgi(Food randomFood){
        System.out.println("⬜⬜⬜⬜⬜⬜⬜⬜⬜");
        System.out.println("⬜⬛⬛⬛⬛⬛⬛⬛⬜");
        System.out.println("⬜⬛⬛⬛" + randomFood.img + "⬛⬛⬛⬜" );
        System.out.println("⬜⬛[" + randomFood.name + "]⬛⬜");
        System.out.println("⬜⬛⬛⬛⬛⬛⬛⬛⬜");
        System.out.println("⬜ 먹을래? y or n: ⬜");
        System.out.println("⬜⬜⬜⬜⬜⬜⬜⬜⬜");
    }
}