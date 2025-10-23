import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    static List<Integer> list = new ArrayList<>();
    static List<Integer> result = new ArrayList<>();
    static int target_count;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];

        for (int i = 1; i < N; i++) {
            if (i * 3 <= N && (dp[i * 3] == 0 || dp[i * 3] > dp[i] + 1)) {
                dp[i * 3] = dp[i] + 1;
            }
            if (i * 2 <= N && (dp[i * 2] == 0 || dp[i * 2] > dp[i] + 1)) {
                dp[i * 2] = dp[i] + 1;
            }
            if (i + 1 <= N && (dp[i + 1] == 0 || dp[i + 1] > dp[i] + 1)) {
                dp[i + 1] = dp[i] + 1;
            }
        }

        sb.append(dp[N]).append("\n").append(N).append(" ");

        target_count = dp[N];
        dfs(N);

        for (int i : result) {
            sb.append(i).append(" ");
        }

        System.out.print(sb);
    }

    static void dfs(int n) {
        if (n == 1) {
            if (list.size() == target_count) {
                result = List.copyOf(list);
            }
            return;
        }

        for (int i = n; i >= 1; i--) {
            if (!result.isEmpty()) {
                return;
            }

            if (dp[i] == dp[n] - 1 && (i * 3 == n || i*2 == n || i+1 == n)) {
                list.add(i);
                dfs(i);
                list.remove(list.size() - 1);
            }
        }
    }
}