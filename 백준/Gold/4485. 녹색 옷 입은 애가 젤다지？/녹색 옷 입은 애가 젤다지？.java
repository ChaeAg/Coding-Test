import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = 0;

        while (true) {
            T++;
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem ").append(T).append(": ").append(bfs(map, N)).append("\n");
        }

        System.out.print(sb);
    }

    static int bfs(int[][] map, int N) {
        int[][] dist = new int[N][N];
        for (int[] d : dist) {
            Arrays.fill(d, INF);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        q.add(new int[]{0, 0, map[0][0]});
        dist[0][0] = map[0][0];

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int[] m : move) {
                int nx = temp[0] + m[0];
                int ny = temp[1] + m[1];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                int nd = temp[2] + map[nx][ny];
                if (nd < dist[nx][ny]) {
                    dist[nx][ny] = nd;
                    q.add(new int[]{nx, ny, nd});
                }
            }
        }

        return dist[N - 1][N - 1];
    }
}