import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        long[][] dp = new long[K + 1][N + 1];
        Arrays.fill(dp[1], 1);

        for (int k = 2; k <= K; k++) {
            for (int n = 0; n <= N; n++) {
                for (int i = 0; i <= n; i++) {
                    dp[k][n] += dp[k - 1][n - i];
                }
                dp[k][n] %= 1000000000;
            }
        }

        System.out.print(dp[K][N]);
    }
}