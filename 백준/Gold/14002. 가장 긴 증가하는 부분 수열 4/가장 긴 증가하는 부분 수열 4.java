import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[N + 1];

        dp[1] = 1;
        map.put(1, 1);

        int max_len = 1;

        for (int i = 2; i <= N; i++) {
            for (int k = 1; k <= N; k++) {
                Integer n = map.get(k);
                if (n == null) break;

                if (score[n] < score[i]) {
                    dp[i] = k + 1;
                    max_len = Math.max(max_len, k + 1);

                    Integer tmp = map.get(k + 1);

                    if (tmp == null || score[tmp] > score[i]) {
                        map.put(k + 1, i);
                    }
                }
            }

            Integer n = map.get(1);
            if (n == null || score[n] > score[i]) {
                map.put(1, i);
            }
            dp[i] = Math.max(dp[i], 1);
        }

        System.out.println(max_len);

        for (int i = N; i > 0; i--) {
            if (dp[i] == max_len) {
                sb.insert(0, " ").insert(0, score[i]);
                max_len--;
            }

            if (max_len == 0) break;
        }

        System.out.print(sb);
    }
}