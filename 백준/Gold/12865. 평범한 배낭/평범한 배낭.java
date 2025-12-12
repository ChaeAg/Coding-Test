import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][K + 1];

        for (int weight = 1; weight <= K; weight++) {
            for (int idx = 1; idx <= N; idx++) {

                dp[idx][weight] = dp[idx - 1][weight];

                if (weights[idx] <= weight && values[idx] > dp[idx][weight]) {
                    dp[idx][weight] = values[idx];
                }

                int needWeight = weight - weights[idx];

                if (needWeight > 0) {

                    if (values[idx] + dp[idx - 1][needWeight] > dp[idx][weight]) {
                        dp[idx][weight] = values[idx] + dp[idx - 1][needWeight];
                    }

                }
            }
        }

        System.out.print(dp[N][K]);
    }
}