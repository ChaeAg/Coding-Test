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

        int[] dp = new int[N];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < N; i++) {
            dp[i] = nums[i];

            for (int k = i - 1; k >= 0; k--) {
                if (nums[k] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[k] + nums[i]);
                }
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}