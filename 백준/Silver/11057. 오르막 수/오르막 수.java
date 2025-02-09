import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 1][10];

        for (int i = 0; i <= 9; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int k = 0; k <= 9; k++) {
                for (int p = k; p <= 9; p++) {
                    dp[i][k] += dp[i - 1][p];
                    dp[i][k] %= 10007;
                }
            }
        }

        System.out.print(dp[N][0] % 10007);
    }
}