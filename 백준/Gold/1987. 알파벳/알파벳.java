import java.io.*;
import java.util.*;
public class Main {
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int R, C;
    static int max = 0;
    static String[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new String[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().split("");
        }

        Set<String> set = new HashSet<>();
        set.add(map[0][0]);
        dfs(0, 0, set);

        System.out.print(max);
    }

    static void dfs(int x, int y, Set<String> visitedAlpha) {
        if (visitedAlpha.size() > max) {
            max = visitedAlpha.size();
        }

        for (int[] move : moves) {
            int next_x = x + move[0];
            int next_y = y + move[1];

            if (next_x < 0 || next_x >= R || next_y < 0 || next_y >= C
                    || visitedAlpha.contains(map[next_x][next_y])) {
                continue;
            }

            visitedAlpha.add(map[next_x][next_y]);

            dfs(next_x, next_y, visitedAlpha);

            visitedAlpha.remove(map[next_x][next_y]);
        }
    }
}