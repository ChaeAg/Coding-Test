import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[3][n + 1];
            for (int k = 1; k <= 2; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 1; i <= n; i++) {
                    arr[k][i] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[3][n + 1];

            dp[1][1] = arr[1][1];
            dp[2][1] = arr[2][1];

            for (int j = 2; j <= n; j++) {
                for (int i = 1; i <= 2; i++) {
                    dp[i][j] = dp[i][j - 1];

                    if (i == 1) {
                        dp[i][j] = Math.max(dp[i + 1][j - 1] + arr[i][j], dp[i][j]);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1] + arr[i][j], dp[i][j]);
                    }
                }
            }

            sb.append(Math.max(dp[1][n], dp[2][n])).append("\n");
        }
        
        System.out.print(sb);
    }
}