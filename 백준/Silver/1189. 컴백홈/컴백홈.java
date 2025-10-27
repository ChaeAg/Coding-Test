import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int cnt = 0;
    static int R, C, K;
    static String[][] map;
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new String[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().split("");
        }

        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);

        System.out.print(cnt);
    }

    static void dfs(int i, int j, int dept) {
        if (dept == K) {
            if (i == 0 && j == C - 1) cnt++;
            return;
        }

        for (int[] m : move) {
            int next_i = i + m[0];
            int next_j = j + m[1];

            if (next_i < 0 || next_i >= R || next_j < 0 || next_j >= C) continue;
            if (visited[next_i][next_j] || map[next_i][next_j].equals("T")) continue;

            visited[next_i][next_j] = true;
            dfs(next_i, next_j, dept + 1);
            visited[next_i][next_j] = false;
        }
    }
}