import java.io.*;
import java.util.*;
public class Main {
    static Map<Integer, List<Integer>> map;
    static int[][] dp;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][2];
        visited = new boolean[N + 1];
        map = new HashMap<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            map.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        visited[1] = true;
        dfs(1);

        System.out.print(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int now) {
        dp[now][0] = 1;
        dp[now][1] = 0;

        for (int c : map.get(now)) {
            if (visited[c]) continue;
            visited[c] = true;  
            dfs(c);
            dp[now][0] += Math.min(dp[c][0], dp[c][1]);
            dp[now][1] += dp[c][0];
        }
    }
}