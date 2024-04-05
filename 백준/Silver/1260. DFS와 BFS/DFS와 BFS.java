import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] graph;
    static Queue<Integer> bfs_queue = new LinkedList<>();
    static boolean[] visited;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }
        visited = new boolean[N+1];
        DFS(V);

        sb.append("\n");

        visited = new boolean[N+1];
        BFS(V);

        System.out.print(sb);
    }

    static void DFS(int start) {
        visited[start] = true;
        sb.append(start).append(" ");
        
        for(int i=1; i<=N; i++) {
            if(graph[start][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }
    }

    static void BFS(int start) {
        bfs_queue.add(start);
        visited[start] = true;
        sb.append(start).append(" ");

        while(!bfs_queue.isEmpty()) {
            int temp = bfs_queue.poll();
            for(int i=1; i<=N; i++) {
                if(graph[temp][i] == 1 && !visited[i]) {
                    bfs_queue.add(i);
                    visited[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }
    }
}