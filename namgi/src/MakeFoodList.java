import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MakeFoodList {
    public List<Food> run() throws IOException {
        List<Food> foodList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("food.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] foodData = line.split(" ");
            String img = foodData[0];
            String name = foodData[1];
            int code = Integer.parseInt(foodData[2]);
            int score = Integer.parseInt(foodData[3]);

            foodList.add(new Food(img, name, code, score));
        }
        return foodList;
    }

}
