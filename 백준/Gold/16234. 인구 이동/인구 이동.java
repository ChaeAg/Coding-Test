import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N, L, R, sum;
    static int[][] arr;
    static boolean[][] visited;
    static List<int[]> connect = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int answer = 0;
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            boolean cond = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;

                    // 초기 세팅
                    visited[i][j] = true;
                    connect = new ArrayList<>();
                    sum = 0;
                    
                    dfs(i, j, connect);

                    if (sum != arr[i][j]) {
                        cond = true;

                        int new_num = sum / connect.size();

                        for (int[] idx : connect) {
                            arr[idx[0]][idx[1]] = new_num;
                        }
                    }
                }
            }

            if (!cond) break;

            answer++;
        }

        System.out.print(answer);
    }

    public static void dfs(int x, int y, List<int[]> connect) {
        connect.add(new int[]{x, y});
        sum += arr[x][y];
        for (int[] m : move) {
            int nx = x + m[0];
            int ny = y + m[1];

            if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1 || visited[nx][ny]) { // 경계 벗어나거나 이미 전에 방문
                continue;
            }
            if (Math.abs(arr[x][y] - arr[nx][ny]) < L || Math.abs(arr[x][y] - arr[nx][ny]) > R) { // 국경선이 열리지 않았다면
                continue;
            }

            visited[nx][ny] = true;
            dfs(nx, ny, connect);
        }
    }
}