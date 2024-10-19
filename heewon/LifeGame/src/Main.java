import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Power power = new Power();
        Life life = new Life();
        Data data = new Data();

        // 프로그램 시작
        power.on();
        // 게임 진행
        life.first();
        data.first(Integer.parseInt(br.readLine()));
        life.second();
        data.second(Integer.parseInt(br.readLine()));
        life.third();
        data.third(Integer.parseInt(br.readLine()));
        life.fourth();
        data.fourth(Integer.parseInt(br.readLine()));

        // 결과 출력
        data.result();

        // 프로그램 종료
        power.off();

    }
}
