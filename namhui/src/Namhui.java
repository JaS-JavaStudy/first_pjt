import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Namhui {
    // 할 일 목록을 저장할 ArrayList
    private ArrayList<String> tasks;

    // Namhui 객체가 생성될 때 할 일 목록 초기화
    public Namhui() {
        tasks = new ArrayList<>();
    }

    // 추가
    public void addTask(String task) {
        tasks.add(task);
        System.out.println("😛 할 일이 추가되었습니다: " + task);
    }

    // 수정
    public void editTask(int index, String newTask) {
        index = index - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, newTask);
            System.out.println("할 일이 수정되었습니다: " + newTask);
        } else {
            System.out.println("😏 잘못된 인덱스입니다. 바보ㅋ💦");
        }
    }

    // 삭제
    public void deleteTask(int index) {
        index = index - 1;
        // 인덱스가 유효한지
        if (index >= 0 && index < tasks.size()) {
            String removedTask = tasks.remove(index);  // 지정한 인덱스의 할 일을 목록에서 삭제
            System.out.println("할 일이 삭제되었습니다: 💨" + removedTask);
        } else {
            System.out.println("😏 잘못된 인덱스입니다. 바보ㅋ💦");
        }
    }

    // 할 일 출력
    public void viewTasks() {
        if (tasks.isEmpty()) {  // 할 일이 비어 있는지
            System.out.println("😑 할 일이 없습니다.");
        } else {
            System.out.println("🎡 현재 할 일 목록:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ": " + tasks.get(i));  // 할 일과 인덱스를 출력
            }
        }
    }

    // 프로그램 시작
    public static void main(String[] args) throws IOException {
        Namhui app = new Namhui();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;

        // 무한 반복: 'exit' 입력할 때까지
        while (true) {
            System.out.println("🎉명령어를 입력하세요 (add, edit, delete, view, exit): ");
            command = reader.readLine();

            switch (command) {
                case "add":  // 추가
                    System.out.println("🦠추가할 할 일을 입력하세요: ");
                    String taskToAdd = reader.readLine();
                    app.addTask(taskToAdd);  // 입력된 할 일을 추가
                    break;

                case "edit":  // 수정
                    System.out.println("🍔수정할 할 일의 인덱스를 입력하세요: ");
                    int editIndex = Integer.parseInt(reader.readLine());
                    System.out.println("🥨새로운 할 일을 입력하세요: ");
                    String newTask = reader.readLine();
                    app.editTask(editIndex, newTask);
                    break;

                case "delete":  // 삭제
                    System.out.println("🦒삭제할 할 일의 인덱스를 입력하세요: ");
                    int deleteIndex = Integer.parseInt(reader.readLine());
                    app.deleteTask(deleteIndex);
                    break;

                case "view":
                    app.viewTasks();  // 현재 할 일 목록 출력
                    break;

                case "exit":
                    System.out.println("🌍프로그램을 종료합니다. 흥!");
                    reader.close();
                    return;  // main 메서드 종료

                default:  // 잘못된 명령어를 입력한 경우
                    System.out.println("잘못된 명령어입니다. 바봌👅");
            }
        }
    }
}
