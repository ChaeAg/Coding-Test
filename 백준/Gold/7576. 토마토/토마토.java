import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Queue<int[]> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[][] box = new int[N][M];
        int zero_count = 0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1) que.add(new int[]{i, j});
                else if(box[i][j] == 0) zero_count++;
            }
        }

        if(zero_count == 0) {
            System.out.print(0);
        }
        else {
            System.out.print(BFS(box));
        }
    }

    static int BFS(int[][] box) {
        int y = 0, x = 0;
        while(!que.isEmpty()) {
            int[] point = que.poll();
            y = point[0];
            x = point[1];
            for(int i=0; i<4; i++) {
                int m_y = y + move[i][0];
                int m_x = x + move[i][1];
                if(m_y < 0 || m_y >= N || m_x < 0 || m_x >= M || box[m_y][m_x] != 0) continue;
                que.add(new int[]{m_y, m_x});
                box[m_y][m_x] = box[y][x] + 1;
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(box[i][j] == 0) {
                    return -1;
                }
            }
        }

        return box[y][x] - 1;
    }
}