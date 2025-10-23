import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] jadu = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            jadu[i] = Integer.parseInt(br.readLine());
        }

        int[][][] dp = new int[3][T + 1][W + 2];

        for (int i = 1; i <= T; i++) {
            for (int j = 1; j <= W + 1; j++) {
                if (jadu[i] == 1) { // 1번 나무에 떨어질 떄
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]) + 1;
                    dp[2][i][j] = Math.max(dp[1][i - 1][j - 1], dp[2][i - 1][j]);
                } else { // 2번 나무에 떨어질 때
                    if (i == 1 && j == 1) continue;
                    dp[2][i][j] = Math.max(dp[2][i - 1][j], dp[1][i - 1][j - 1]) + 1;
                    dp[1][i][j] = Math.max(dp[2][i - 1][j - 1], dp[1][i - 1][j]);
                }
            }
        }

        int max = 0;
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j <= W + 1; j++) {
                max = Math.max(max, dp[i][T][j]);
            }
        }

        System.out.print(max);
    }
}