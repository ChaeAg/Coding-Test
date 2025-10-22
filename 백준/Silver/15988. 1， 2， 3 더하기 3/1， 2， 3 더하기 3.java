import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];

        int max = 0;
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = max < arr[i] ? arr[i] : max;
        }

        long[] dp = new long[max + 1];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;

        int last = 3;

        for (int n : arr) {
            if (last < n) {
                for (int i = last + 1; i <= n; i++) {
                    dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
                }
                last = n;
            }
            sb.append(dp[n] % 1000000009).append("\n");
        }

        System.out.print(sb);
    }
}