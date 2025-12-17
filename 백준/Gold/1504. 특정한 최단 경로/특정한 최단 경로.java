import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[][] moneys = new int[N + 1][N + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());

            map.computeIfAbsent(start, k -> new ArrayList<>()).add(end);
            map.computeIfAbsent(end, k -> new ArrayList<>()).add(start);

            moneys[start][end] = money;
            moneys[end][start] = money;
        }

        st = new StringTokenizer(br.readLine());
        int[] point = new int[2];
        point[0] = Integer.parseInt(st.nextToken());
        point[1] = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> {
            if (o1[2] != o2[2]) {
                return o2[2] - o1[2];
            }
            if (o1[0] == point[0] || o1[0] == point[1]) {
                return -1;
            }
            if (o2[0] == point[0] || o2[0] == point[1]) {
                return 1;
            }
            return o1[1] - o2[1];
        });

        int[][] result = new int[N + 1][4];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }

        if (point[0] == 1) {
            que.add(new int[]{1, 0, 1}); // 3번째 인덱스 0 또는 1 또는 2 또는 3
            result[1][1] = 0;
        } else if (point[1] == 1) {
            que.add(new int[]{1, 0, 2}); // 3번째 인덱스 0 또는 1 또는 2 또는 3
            result[1][2] = 0;
        } else {
            que.add(new int[]{1, 0, 0}); // 3번째 인덱스 0 또는 1 또는 2 또는 3
            result[1][0] = 0;
        }

        while (!que.isEmpty()) {
            int[] now = que.poll();
            int cond = now[2];

            List<Integer> list = map.get(now[0]);

            if (list == null) {
                continue;
            }

            for (int i : list) {
                int copyCond = cond;

                if (i == point[0]) {
                    if (copyCond == 0) {
                        copyCond = 1;
                    } else if (copyCond == 2) {
                        copyCond = 3;
                    }
                } else if (i == point[1]) {
                    if (copyCond == 0) {
                        copyCond = 2;
                    } else if (copyCond == 1) {
                        copyCond = 3;
                    }
                }

                if (result[i][copyCond] == Integer.MAX_VALUE || result[i][copyCond] > now[1] + moneys[now[0]][i]) {
                    que.add(new int[]{i, now[1] + moneys[now[0]][i], copyCond});
                    result[i][copyCond] = Math.min(result[i][copyCond], now[1] + moneys[now[0]][i]);
                }
            }
        }

        System.out.print(result[N][3] == Integer.MAX_VALUE ? -1 : result[N][3]);
    }
}