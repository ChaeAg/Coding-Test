import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<int[]> store = new ArrayList<>();
            int sx=0, sy=0, fx=0, fy=0;

            for(int i=0; i<n+2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if(i == 0) { // 상근이 위치
                    sx = x;
                    sy = y;
                }
                else if(i == n+1) { // 페스티벌 위치
                    fx = x;
                    fy = y;
                }
                else {
                    store.add(new int[]{x, y}); // 편의점 위치
                }
            }
            sb.append(bfs(store, sx, sy, fx, fy, n) ? "happy" : "sad").append("\n");
        }

        System.out.print(sb);
    }

    static boolean bfs(List<int[]> store, int sx, int sy, int fx, int fy, int n) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n]; // 편의점 방문 여부 체크

        q.add(new int[] {sx,sy}); // 상근이 시작점 넣어줌

        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0], y = temp[1];

            if(Math.abs(x-fx) + Math.abs(y-fy) <= 1000) { // 맥주 20개로 갈 수 있는 거리 1000. 갈 수 있으면 true
                return true;
            }

            for(int i=0; i<n; i++) { // 편의점 찾기
                if(!visited[i]) {
                    int nx = store.get(i)[0], ny = store.get(i)[1];
                    if(Math.abs(x - nx) + Math.abs(y - ny) <= 1000) { // 편의점까지 갈 수 있음
                        visited[i] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return false;
    }

}