import java.util.List;
import java.util.ArrayList;

public class User {
    String name;
    int limit_point;
    int score;
    List<String> eatenFoods;

    public User(String name ){
        this.name = name;
        this.limit_point = 1010;
        this.score = 0;
        this.eatenFoods = new ArrayList<>();
    }

    public void addscore(int foodscore){
        this.score += foodscore;
    }
    public void addEatenFood(String food) {  // 음식을 먹은 리스트에 추가하는 메서드
        this.eatenFoods.add(food);
    }

    public void startuser(){
        System.out.println("⬜⬜⬜⬜⬜⬜⬜⬜⬜");
        System.out.println("⬜ 예약손님 : " + name + " ⬜" );
        System.out.println("⬜⬜⬜⬜⬜⬜⬜⬜⬜");
    }
}
