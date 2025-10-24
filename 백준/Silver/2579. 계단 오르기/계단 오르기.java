import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[3][n + 1];

        for (int i = 1; i <= n; i++) {
            dp[2][i] = dp[1][i] = Integer.parseInt(br.readLine());
        }

        for (int i = 2; i <= n; i++) {
            dp[1][i] += Math.max(dp[1][i - 2], dp[2][i - 2]);
            dp[2][i] = dp[2][i] + dp[1][i - 1];
        }

        System.out.print(Math.max(dp[1][n], dp[2][n]));
    }
}