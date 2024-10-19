public class Data {
    static int first;
    static int second;
    static int third;
    static int fourth;
    static int result;

    public static void first(int answer) {
        first = answer;
        result += first;
    }

    public static void second(int answer) {
        second = answer;
        result += second;
    }

    public static void third(int answer) {
        third = answer;
        result += third;
    }

    public static void fourth(int answer) {
        fourth = answer;
        result += fourth;
    }

    public static void result() {
        if (1 <= result && result <= 4) {
            System.out.println("END_1 : 당신은 사랑꾼입니다.");
        } else if (5 <= result && result <= 8) {
            System.out.println("END_2 : 당신은 의리파입니다.");
        } else if (9 <= result && result <= 12) {
            System.out.println("END_3 : 당신은 명예가 중요합니다.");
        } else if (result >= 13 && result <= 16 ) {
            System.out.println("END_4 : 당신은 부자가 될 것입니다.");
        }else {
            System.out.println("입력이 잘 못 됐습니다.");
            System.out.println("게임을 재 시작 해주세요.");
        }
    }
}

