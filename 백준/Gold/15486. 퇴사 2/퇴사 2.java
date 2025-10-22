import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            String[] tmp = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(tmp[0]);
            arr[i][1] = Integer.parseInt(tmp[1]);
        }

        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);

            int next_m = arr[i][1] + dp[i];
            int next_d = i + arr[i][0];

            if (next_d <= N + 1 && dp[next_d] < next_m) { // 이득이라서 덮어씌우기
                dp[next_d] = next_m;
            }
        }

        System.out.print(dp[N + 1]);
    }
}