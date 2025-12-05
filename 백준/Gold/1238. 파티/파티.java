import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[][] moneys;
    static int N, M, X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        moneys = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());

            moneys[start][end] = money;
        }

        int[][] times = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
            q.add(new int[]{i, 0});

            while (!q.isEmpty()) {
                int[] now = q.poll();

                for (int k = 1; k <= N; k++) {
                    if (k == i) {
                        continue;
                    }
                    if (moneys[now[0]][k] != 0) { // 가는 길 O
                        int newMoney = now[1] + moneys[now[0]][k];
                        if (times[i][k] == 0 || newMoney < times[i][k]) {
                            times[i][k] = newMoney;
                            q.add(new int[]{k, newMoney});
                        }
                    }
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            int totalTime = times[X][i] + times[i][X];
            if (maxTime < totalTime) {
                maxTime = totalTime;
            }
        }

        System.out.print(maxTime);
    }
}