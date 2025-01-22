import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 동, 서, 남, 북 순
    static int max_size = 0;
    static int count;
    static boolean[][] visited;
    static String[][] graph;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int art_count = 0;

        visited = new boolean[n][m];
        graph = new String[n][m];
        for (int i = 0; i < n; i++) {
            graph[i] = br.readLine().split(" ");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && graph[i][j].equals("1")) {
                    visited[i][j] = true;
                    count = 1;
                    dfs(i, j);
                    art_count++;
                    max_size = Math.max(max_size, count);
                }
            }
        }

        System.out.print(art_count + "\n" + max_size);
    }

    public static void dfs(int i, int j) {
        for (int[] a : move) {
            int next_i = i + a[0];
            int next_j = j + a[1];

            if (next_i < 0 || next_i >= n
                    || next_j < 0 || next_j >= m
                    || visited[next_i][next_j]
                    || graph[next_i][next_j].equals("0")) {
                continue;
            }

            count++;
            visited[next_i][next_j] = true;
            dfs(next_i, next_j);
        }
    }
}