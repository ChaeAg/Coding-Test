import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i <= N; i++) {
            for (int j = i - 1; j > 0; j--) {
                dp[i] = Math.max(dp[i], dp[j] + dp[i - j]);
            }
        }

        System.out.print(dp[N]);
    }
}