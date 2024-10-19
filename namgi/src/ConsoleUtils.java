public class ConsoleUtils {
    public static void clearConsole() {
        // 콘솔에서 이전 내용이 보이지 않도록 50줄의 빈 줄 출력
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
