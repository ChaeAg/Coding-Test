import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] maze = new int[N][M];
        for(int i=0; i<N; i++) {
            maze[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        BFS(maze);
        System.out.print(maze[N-1][M-1]);
    }

    static void BFS(int[][] maze) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0});
        visited[0][0] = true;
        maze[0][0] = 1;

        while(!que.isEmpty()) {
            int[] temp = que.poll();
            int y = temp[0];
            int x = temp[1];
            for(int i=0; i<4; i++) {
                int m_y = y + move[i][0];
                int m_x = x + move[i][1];
                if(m_y < 0 || m_y >= N || m_x < 0 || m_x >= M) continue;
                if(!visited[m_y][m_x] && maze[m_y][m_x] == 1) {
                    visited[m_y][m_x] = true;
                    maze[m_y][m_x] = maze[y][x] + 1;
                    que.add(new int[]{m_y, m_x});
                }
                if(m_y == N-1 && m_x == M-1) break;
            }
        }
    }
}