import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            boolean[][] connected = new boolean[N][N];
            for(int j=0; j<M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                connected[a-1][b-1] = true;
                connected[b-1][a-1] = true;
            }

            sb.append(bfs(N, connected)).append("\n");
        }

        System.out.print(sb);
    }

    public static int bfs(int N, boolean[][] connected) {
        boolean[] visited = new boolean[N];
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        visited[0] = true;
        int count = 0;

        while(!que.isEmpty()) {
            int airplane = que.poll();

            for(int i=0; i<N; i++) {
                if(connected[airplane][i]) {
                    if(!visited[i]) {
                        que.add(i);
                        visited[i] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}