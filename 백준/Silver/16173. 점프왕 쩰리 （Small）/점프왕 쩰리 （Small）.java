import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[][] game_zone;
    public static int N;
    public static String answer = "Hing";
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        game_zone = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            game_zone[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        dfs(0, 0);
        System.out.print(answer);
    }

    public static void dfs(int x, int y) {
        if(game_zone[y][x] == -1) {
            answer = "HaruHaru";
            return;
        }

        for(int i=0; i<2; i++) {
            if(game_zone[y][x] == 0) continue;

            int move_x = x + game_zone[y][x] * (1 - i);
            int move_y = y + game_zone[y][x] * i;

            if (move_x >= N || move_y >= N || visited[move_y][move_x]) continue;

            visited[move_y][move_x] = true;
            dfs(move_x, move_y);
            visited[move_y][move_x] = false;
        }
    }
}