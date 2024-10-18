import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.print("닉네임 입력 : ");
        String userName = sc.nextLine();
        System.out.print("비밀번호 입력 : ");
        String password = sc.nextLine();
        User user = new User(userName);

        user.startuser();

        MakeFoodList foodManager = new MakeFoodList();
        List<Food> foodList = foodManager.run();


        // 3. 프로그램 시작
        boolean continueGame = true;
        Random random = new Random();

        while (continueGame && user.score < user.limit_point) {
            // 랜덤으로 음식 선택
            Food randomFood = foodList.get(random.nextInt(foodList.size()));

            // 음식 출력
            System.out.println("⬜⬜⬜⬜⬜⬜⬜⬜⬜");
            System.out.println("⬜⬛⬛⬛⬛⬛⬛⬛⬜");
            System.out.println("⬜⬛⬛⬛" + randomFood.img + "⬛⬛⬛⬜" );
            System.out.println("⬜⬛[" + randomFood.name + "]⬛⬜");
            System.out.println("⬜⬛⬛⬛⬛⬛⬛⬛⬜");
            System.out.println("⬜ 먹을래? y or n: ⬜");
            System.out.println("⬜⬜⬜⬜⬜⬜⬜⬜⬜");
            String choice = sc.nextLine();

            // 4. 음식 선택 여부 확인
            if (choice.equalsIgnoreCase("y")) {
                if (user.score + randomFood.score <= user.limit_point) {
                    user.addscore(randomFood.score);
                    user.addEatenFood(randomFood.img);
                    System.out.println(randomFood.img + " 선택!!");
                    System.out.println(String.join(" ", user.eatenFoods));
                } else {
                    fullcry();
                    continueGame = false;
                }
            } else {
                System.out.println(randomFood.img + "는 버려졌습니다.");
                randomFood = foodList.get(random.nextInt(foodList.size()));
                System.out.print("더 먹을수 있어? yes or no: ");
                String continueChoice = sc.nextLine();
                if (!continueChoice.equalsIgnoreCase("yes")) {
                    continueGame = false;
                    System.out.println("✨✨"+user.score+"점 획득 ✨✨");
                }
            }
        }
        System.out.println("fin");
    }
    static void fullcry(){
        for (int i = 0; i < 3; i++) {
            System.out.println("🥵 배불러 ㅠㅠ 🥵");
        }
    }
}