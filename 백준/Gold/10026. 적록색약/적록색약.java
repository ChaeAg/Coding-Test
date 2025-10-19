import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static boolean[][] visited;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new String[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }

        int nomal_person = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, N, 0);
                    nomal_person++;
                }
            }
        }

        int special_person = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, N, 1);
                    special_person++;
                }
            }
        }

        System.out.print(nomal_person + " " + special_person);
    }

    static void bfs(int x, int y, int N, int cond) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] move : moves) {
                int n_x = cur[0] + move[0];
                int n_y = cur[1] + move[1];

                if (n_x < 0 || n_x >= N || n_y < 0 || n_y >= N) {
                    continue;
                }
                if (visited[n_x][n_y]) {
                    continue;
                }
                if (cond == 0 && !map[x][y].equals(map[n_x][n_y])) {
                    continue;
                }
                if (cond == 1 && (!map[x][y].equals("B") && map[n_x][n_y].equals("B")) || (!map[n_x][n_y].equals("B")
                        && map[x][y].equals("B"))) {
                    continue;
                }

                q.add(new int[]{n_x, n_y});
                visited[n_x][n_y] = true;
            }
        }
    }
}