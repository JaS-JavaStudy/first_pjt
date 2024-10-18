import java.util.Scanner;

public class CoffeeKiosk {
    private static String[] menu = {"아메리카노", "카페라떼", "바닐라라떼"};  // 메뉴
    private static int[] prices = {2000, 2500, 3000};  // 가격
    private static String[] sizes = {"S", "M", "L"};  // 사이즈
    private static int[] sizePrices = {0, 500, 1000};  // S, M, L 순서대로 추가 가격
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== 커피 주문 키오스크 ===");

        int menuChoice = orderMenu();
        int sizeChoice = chooseSize();
        int totalPrice = calculatePrice(menuChoice, sizeChoice);
        displayOrder(menuChoice, sizeChoice, totalPrice);
        processPayment(totalPrice);

        scanner.close();
    }

    // 메뉴 주문 메서드
    private static int orderMenu() {
        System.out.println("메뉴를 선택하세요:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i] + " - " + prices[i] + "원 (S 사이즈 기준)");
        }
        return scanner.nextInt() - 1;
    }

    // 사이즈 선택 메서드
    private static int chooseSize() {
        System.out.println("사이즈를 선택하세요:");
        for (int i = 0; i < sizes.length; i++) {
            System.out.println((i + 1) + ". " + sizes[i] + " (+" + sizePrices[i] + "원)");
        }
        return scanner.nextInt() - 1;
    }

    // 가격 계산 메서드
    private static int calculatePrice(int menuChoice, int sizeChoice) {
        return prices[menuChoice] + sizePrices[sizeChoice];
    }

    // 주문 내역 확인 메서드
    private static void displayOrder(int menuChoice, int sizeChoice, int totalPrice) {
        System.out.println("\n=== 주문 내역 ===");
        System.out.println("메뉴: " + menu[menuChoice]);
        System.out.println("사이즈: " + sizes[sizeChoice]);
        System.out.println("가격: " + totalPrice + "원");
    }

    // 결제 메서드
    private static void processPayment(int totalPrice) {
        System.out.println("\n결제 방법을 선택하세요 (1: 카드, 2: 현금):");
        int paymentChoice = scanner.nextInt();
        String paymentMethod = (paymentChoice == 1) ? "카드" : "현금";

        System.out.println(paymentMethod + "(으)로 " + totalPrice + "원 결제가 완료되었습니다.");
        System.out.println("이용해 주셔서 감사합니다!");
    }
}