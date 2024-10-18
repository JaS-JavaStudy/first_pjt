import java.io.*;

public class BMR {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("성별을 입력하세요 (남/여): ");
        String gender = br.readLine();

        System.out.print("체중(kg)을 입력하세요: ");
        double weight = Double.parseDouble(br.readLine());

        System.out.print("키(cm)를 입력하세요: ");
        double height = Double.parseDouble(br.readLine());

        System.out.print("나이(세)를 입력하세요: ");
        int age = Integer.parseInt(br.readLine());

        double bmr = calculate(gender, weight, height, age);
        System.out.println("기초대사량(BMR): " + bmr + " kcal");
    }

    public static double calculate(String gender, double weight, double height, int age) {
        if (gender.equals("남")) {
            return 66.47 + (13.75 * weight) + (5 * height) - (6.76 * age);
        } else if (gender.equals("여")) {
            return 655.1 + (9.56 * weight) + (1.85 * height) - (4.68 * age);
        } else {
            System.out.println("이 사람은 중성 입니다.");
            return 0;
        }
    }
}
