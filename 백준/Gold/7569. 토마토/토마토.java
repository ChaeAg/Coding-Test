import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H;
    static int[][] move = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}}; // 위 아래 앞 뒤 왼 오 순서
    static Queue<int[]> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        int[][][] box = new int[H][N][M];
        int zero_count = 0;

        for(int i=0; i<H; i++) {
            for(int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k] == 1) que.add(new int[]{i, j, k});
                    else if(box[i][j][k] == 0) zero_count++;
                }
            }
        }

        if(zero_count == 0) {
            System.out.print(0);
        }
        else {
            System.out.print(BFS(box));
        }
    }

    static int BFS(int[][][] box) {
        int h = 0, y = 0, x = 0;
        while(!que.isEmpty()) {
            int[] point = que.poll();
            h = point[0];
            y = point[1];
            x = point[2];
            for(int i=0; i<6; i++) {
                int m_h = h + move[i][0];
                int m_y = y + move[i][1];
                int m_x = x + move[i][2];
                if(m_h < 0 || m_h >= H || m_y < 0 || m_y >= N || m_x < 0 || m_x >= M || box[m_h][m_y][m_x] != 0) continue;
                que.add(new int[]{m_h, m_y, m_x});
                box[m_h][m_y][m_x] = box[h][y][x] + 1;
            }
        }

        for(int i=0; i<H; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {
                    if(box[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }

        return box[h][y][x] - 1;
    }
}