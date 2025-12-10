import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[][] times = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(times[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            map.computeIfAbsent(A, k -> new HashSet<>()).add(B);
            times[A][B] = Math.min(times[A][B], C);
        }

        long[] result = new long[N + 1];
        Arrays.fill(result, Long.MAX_VALUE);
        result[1] = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int n = 1; n <= N; n++) {
                if (result[n] == Long.MAX_VALUE) {
                    continue;
                }
                Set<Integer> set = map.get(n);

                if (set == null) {
                    continue;
                }

                for (int k : set) {
                    if (result[k] > result[n] + times[n][k]) {
                        result[k] = result[n] + times[n][k];
                    }
                }
            }
        }

        boolean isUpdate = false;
        for (int n = 1; n <= N; n++) {
            if (result[n] == Long.MAX_VALUE) {
                continue;
            }
            Set<Integer> set = map.get(n);

            if (set == null) {
                continue;
            }

            for (int k : set) {
                if (result[k] > result[n] + times[n][k]) {
                    isUpdate = true;
                    break;
                }
            }

            if (isUpdate) {
                break;
            }
        }

        if (isUpdate) {
            sb.append(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                sb.append(result[i] == Long.MAX_VALUE ? -1 : result[i]).append("\n");
            }
        }

        System.out.print(sb);
    }
}