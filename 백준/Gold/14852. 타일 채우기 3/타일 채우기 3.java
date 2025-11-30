import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(2);
            return;
        }

        long[] non_over = new long[N + 1];
        long[] over_top = new long[N + 1];
        long[] over_bot = new long[N + 1];

        non_over[1] = 2;
        over_top[1] = 1;
        over_bot[1] = 1;
        non_over[2] = 7;
        over_top[2] = 3;
        over_bot[2] = 3;

        for (int i = 3; i <= N; i++) {
            non_over[i] = (over_top[i - 1] + over_bot[i - 1] + non_over[i - 1] * 2 + non_over[i - 2]) % 1000000007;
            over_top[i] = (non_over[i - 1] + over_bot[i - 1]) % 1000000007;
            over_bot[i] = (non_over[i - 1] + over_top[i - 1]) % 1000000007;
        }

        System.out.println(non_over[N]);
    }
}