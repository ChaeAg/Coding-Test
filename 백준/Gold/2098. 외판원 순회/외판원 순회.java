import java.io.*;
import java.util.*;
public class Main {
    static int[][] map;
    static int N, fullBit;
    static int[][] dp;
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        fullBit = (1 << N) - 1;

        dp = new int[N][fullBit + 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        StringTokenizer st;

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(TPS(0, 1));
    }

    static int TPS(int now, int check) {
        if (check == fullBit) {
            if (map[now][0] == 0) {
                return INF;
            }
            return map[now][0];
        }

        if (dp[now][check] > -1) {
            return dp[now][check];
        }

        dp[now][check] = INF;

        for (int i = 0; i < N; i++) {
            int next = check | (1 << i);

            if (map[now][i] != 0 && (check & (1 << i)) == 0) {
                dp[now][check] = Math.min(dp[now][check], TPS(i, next) + map[now][i]);
            }
        }

        return dp[now][check];
    }
}