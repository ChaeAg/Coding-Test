import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[][] arr;
    static int min_cha = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.print(min_cha);
    }

    static void dfs(int idx, int dept) {
        if (dept == N / 2) { // 정원 다 모임
            int sum1 = 0, sum2 = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    
                    if (visited[i] && visited[j]) {
                        sum1 += arr[i][j];
                    } else if (!visited[i] && !visited[j]) {
                        sum2 += arr[i][j];
                    }
                }
            }

            min_cha = Math.min(min_cha, Math.abs(sum1 - sum2));
            return;
        }

        for (int i = idx; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            dfs(i, dept + 1);
            visited[i] = false;
        }
    }
}