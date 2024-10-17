import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Power power = new Power();
        Life life = new Life();
        Data data = new Data();
        power.on();
        life.first();
        data.first(Integer.parseInt(br.readLine()));


        data.result();

        power.off();
    }
}
