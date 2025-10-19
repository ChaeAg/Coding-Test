import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        int[] goal = new int[2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }

        int[][] result = bfs(goal[0], goal[1], n, m);
        StringBuilder sb = new StringBuilder();

        for (int[] i : result) {
            for (int j : i) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static int[][] bfs(int x, int y, int n, int m) {
        int[][] dist = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        q.add(new int[]{x, y});
        dist[x][y] = 0;
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] move : moves) {
                int n_x = cur[0] + move[0];
                int n_y = cur[1] + move[1];

                if (n_x < 0 || n_x >= n || n_y < 0 || n_y >= m) {
                    continue;
                }
                if (visited[n_x][n_y]) {
                    continue;
                }
                if (map[n_x][n_y] == 0) {
                    continue;
                }

                q.add(new int[]{n_x, n_y});
                visited[n_x][n_y] = true;
                dist[n_x][n_y] = dist[cur[0]][cur[1]] + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    dist[i][j] = -1;
                }
            }
        }

        return dist;
    }
}