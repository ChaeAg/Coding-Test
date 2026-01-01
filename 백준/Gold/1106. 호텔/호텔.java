import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] cities = new int[N][2]; // [cost, people]

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cities[i][0] = Integer.parseInt(st.nextToken()); // cost
            cities[i][1] = Integer.parseInt(st.nextToken()); // people
        }

        int[] dp = new int[C + 101];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < C + 101; i++) {
            for (int j = 0; j < N; j++) {
                int cost = cities[j][0];
                int people = cities[j][1];

                int p = Math.max(0, i - people);
                if (dp[p] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[p] + cost);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = C; i < C + 101; i++) {
            answer = Math.min(answer, dp[i]);
        }

        System.out.print(answer);
    }
}