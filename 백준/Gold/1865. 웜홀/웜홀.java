import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    // 모든 정점에 대해 음수사이클이 존재하면 그 테스트케이스는 YES
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            Map<Integer, Set<Integer>> map = new HashMap<>();
            int[][] connect = new int[N + 1][N + 1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                map.computeIfAbsent(S, k -> new HashSet<>()).add(E);
                map.computeIfAbsent(E, k -> new HashSet<>()).add(S);

                if (connect[S][E] == 0 || connect[S][E] > T) {
                    connect[S][E] = T;
                }

                if (connect[E][S] == 0 || connect[E][S] > T) {
                    connect[E][S] = T;
                }
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());

                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                map.computeIfAbsent(S, k -> new HashSet<>()).add(E);

                if (connect[S][E] == 0 || connect[S][E] > -T) {
                    connect[S][E] = -T;
                }
            }

            int[] result = new int[N + 1];

            for (int i = 1; i < N; i++) {
                for (int k = 1; k <= N; k++) {
                    Set<Integer> set = map.get(k);

                    if (set == null) {
                        continue;
                    }

                    for (int n : set) {
                        if (result[n] > result[k] + connect[k][n]) {
                            result[n] = result[k] + connect[k][n];
                        }
                    }
                }
            }

            boolean isOk = true;

            for (int k = 1; k <= N; k++) {
                Set<Integer> set = map.get(k);

                if (set == null) {
                    continue;
                }

                for (int n : set) {
                    if (result[n] > result[k] + connect[k][n]) {
                        isOk = false;
                        break;
                    }
                }

                if (!isOk) {
                    break;
                }
            }

            sb.append(isOk ? "NO" : "YES").append("\n");
        }

        System.out.print(sb);
    }
}