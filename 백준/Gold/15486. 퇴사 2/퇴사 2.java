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

        int max = 0;
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            int next_m = arr[i][1];
            
            if (dp[i] != 0) { // 더해서 시작할 수 있다는 뜻
                next_m += dp[i];
                for (int d = i + 1; d < Math.min(i + arr[i][0], N + 1); d++) {
                    dp[d] = Math.max(dp[d], dp[i]);
                }
            }
            
            int next_d = i + arr[i][0];

            if (next_d <= N + 1 && dp[next_d] < next_m) { // 이득이라서 덮어씌우기
                dp[next_d] = next_m;
                max = Math.max(dp[next_d], max);
            }
        }

        System.out.print(max);
    }
}