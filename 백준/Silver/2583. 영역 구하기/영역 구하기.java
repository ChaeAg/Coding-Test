import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[][] monun;
    static List<Integer> result = new ArrayList<>();
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int area;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        monun = new int[N][M];

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());
            int end_x = Integer.parseInt(st.nextToken());
            int end_y = Integer.parseInt(st.nextToken());

            for(int x = start_x; x < end_x; x++) {
                for(int y = start_y; y < end_y; y++) {
                    monun[x][y] = -1;
                }
            }
        }

        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(monun[i][j] == 0) {
                    area = 0;
                    dfs(i, j);
                    count++;
                    result.add(area);
                }
            }
        }

        Collections.sort(result);
        System.out.println(count);
        for (int re : result) {
            if (re == 0)
                break;
            sb.append(re).append(" ");
        }
        System.out.print(sb);
    }

    public static void dfs(int x, int y) {
        monun[x][y] = 1;
        area++;
        for(int i=0; i<4; i++) {
            int m_x = x + move[i][0];
            int m_y = y + move[i][1];
            if(m_x < 0 || m_x >= N || m_y < 0 || m_y >= M || monun[m_x][m_y] != 0) continue;
            dfs(m_x, m_y);
        }
    }
}