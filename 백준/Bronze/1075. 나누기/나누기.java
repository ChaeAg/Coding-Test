import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        N = N / 100 * 100;
        String answer = "";
        for (int i = 0; i <= 99; i++) {
            if (((N + i) % F) == 0) {
                if (i < 10) answer += "0";
                answer += i;
                break;
            }
        }

        System.out.print(answer);
    }
}