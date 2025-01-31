import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][n * 2 - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[0][n - 1] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++) { // 줄 개수
            st = new StringTokenizer(br.readLine());
            int d = 0;
            int start = n - 1 - i;

            for (int k = 0; k <= i; k++) { // 한 줄 개수
                int now_idx = start + d;
                int num = Integer.parseInt(st.nextToken());
                d += 2;

                int left = now_idx == 0 ? 0 : dp[i - 1][now_idx - 1];
                int right = now_idx == n * 2 - 2 ? 0 : dp[i - 1][now_idx + 1];

                dp[i][now_idx] = Math.max(left, right) + num;
            }
        }

        int max = dp[n - 1][0];
        for (int i = 1; i < n * 2 - 1; i++) {
            max = Math.max(dp[n - 1][i], max);
        }

        System.out.print(max);
    }
}