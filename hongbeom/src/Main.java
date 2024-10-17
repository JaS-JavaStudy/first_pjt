import java.io.*;
import java.util.*;

public class Main {
    // 질문과 답변을 저장할 리스트
    private static List<String[]> questions = new ArrayList<>();
    // 사용자의 점수를 저장할 변수
    private static int score = 0;

    public static void main(String[] args) {
        // 질문 데이터 로드
        loadQuestions();
        // 시작 메시지 출력
        System.out.println("*주의* 티니핑의 1기와 3기의 캐릭터들이 섞여있습니다 !");
        System.out.println();
        System.out.println("티니핑 월드 퀴즈쇼에 오신걸 환영합니다 !");
        // 퀴즈 시작
        shuffleQuiz();
    }

    // questions.txt 파일에서 질문과 답변을 읽어오는 메소드
    private static void loadQuestions() {
        try (BufferedReader br = new BufferedReader(new FileReader("questions.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // 각 줄을 쉼표로 분리하여 질문과 답변으로 나누고 리스트에 추가
                questions.add(line.split(","));
            }
        } catch (IOException e) {
            // 파일 읽기 실패시 에러 메시지 출력 후 프로그램 종료
            System.out.println("질문을 불러오는 데 문제가 발생했습니다: " + e.getMessage());
            System.exit(1);
        }
    }

    // 질문을 하고 사용자의 답변을 받는 메소드
    private static void ask(int Q) {
        Scanner sc = new Scanner(System.in);
        System.out.println("질문 : " + questions.get(Q)[0]);
        System.out.print("정답을 입력하세요: ");
        String answer = sc.nextLine();
        check(Q, answer);
    }

    // 사용자의 답변을 체크하는 메소드
    private static void check(int Q, String answer) {
        String correctAnswer = questions.get(Q)[1];
        if (answer.equalsIgnoreCase(correctAnswer)) {
            score++;
            System.out.println("정답입니다 ! 티니핑~");
        } else {
            System.out.println("땡 ! 정답은 " + correctAnswer + "입니다. 티니핑 ㅠ");
        }
        System.out.println();
    }

    // 퀴즈를 섞고 실행하는 메소드
    private static void shuffleQuiz() {
        // 질문 순서를 랜덤하게 섞음
        Collections.shuffle(questions);
        // 20개의 질문을 물어봄 (질문이 20개 미만이면 모든 질문을 물어봄)
        for (int i = 0; i < Math.min(20, questions.size()); i++) {
            ask(i);
        }
        System.out.println("티니핑 퀴즈쇼가 끝났습니다 !");
        System.out.println();
        showResult();
    }

    // 최종 결과를 보여주는 메소드
    private static void showResult() {
        System.out.println("당신의 점수는");
        System.out.println(score + " / 20" + " 입니다 !");
        // 점수에 따른 결과 메시지 출력
        if (score >= 15) {
            System.out.println("당신은 최고핑 ~");
        } else if (score >= 10) {
            System.out.println("티니핑에 대해서 잘 아시네요 !");
        } else if (score >= 5) {
            System.out.println("티니핑이 뭔지는 아시는군요 !");
        } else if (score >= 1) {
            System.out.println("좀 더 유행을 따라가시길 ..");
        } else {
            System.out.println("아무것도 몰라핑?");
        }
    }
}