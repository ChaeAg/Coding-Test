import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] left_dp = new int[N];

        int[] dp = new int[N];
        dp[0] = nums[0];
        int cnt = 1;
        left_dp[0] = cnt;

        for (int i = 1; i < N; i++) {
            for (int k = 0; k <= i; k++) {
                if (dp[k] >= nums[i]) {
                    dp[k] = nums[i];
                    break;
                }
                if (k == i) {
                    dp[k] = nums[i];
                    cnt++;
                }
            }
            left_dp[i] = cnt;
        }

        int[] right_dp = new int[N];

        dp = new int[N];
        dp[N - 1] = nums[N - 1];
        cnt = 1;
        right_dp[N - 1] = cnt;

        for (int i = N - 2; i >= 0; i--) {
            for (int k = N - 1; k >= i; k--) {
                if (dp[k] >= nums[i]) {
                    dp[k] = nums[i];
                    break;
                }
                if (k == i) {
                    dp[k] = nums[i];
                    cnt++;
                }
            }

            right_dp[i] = cnt;
        }

        int maxCnt = 0;
        for (int i = 0; i < N; i++) {
            maxCnt = Math.max(maxCnt, left_dp[i] + right_dp[i] - 1);
        }

        System.out.print(maxCnt);
    }
}