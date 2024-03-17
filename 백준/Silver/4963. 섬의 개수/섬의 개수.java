import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int w, h;
    static boolean[][] check;
    static String[][] map;
    static int[] move_w = {0, 0, -1, 1};
    static int[] move_h = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            /*
            변수 세팅
            */
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;
            map = new String[h][w];
            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().split(" ");
            }
            check = new boolean[h][w];
            int island_count = 0;
            /*
            dfs 고고
             */
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(dfs(i, j, false)) island_count++;
                }
            }

            sb.append(island_count).append("\n");
        }
        System.out.print(sb);
    }
    static boolean dfs(int x, int y, boolean isIsland) {
        if(x >= h || x < 0 || y >= w || y < 0) {
            return false;
        }

        if(!check[x][y] && map[x][y].equals("1")) {
            // 방문한 1은 이미 센 섬이니 true로 바꿔주고 다시 false로 바꿔줄 필요가 없다.
            check[x][y] = true;
            // 처음 들어온 섬 일부분(사각형)이면 isIsland가 false니 true로 바꿔준다.
            if(!isIsland) {
                isIsland = true;
            }
            // 상하좌우대각선 모두 탐색
            for(int i=0; i<4; i++) {
                for (int j=0; j<4; j++) {
                    dfs(x + move_h[i], y + move_w[j], isIsland);
                }
            }
        }

        // 섬이 있었는지 반환
        return isIsland;
    }
}