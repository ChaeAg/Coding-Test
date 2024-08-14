import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.print(bfs(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }

    public static int bfs(int N, int K) {
        boolean[] visited = new boolean[100001];
        int[] time = new int[100001];
        int[] move = {2, -1, 1};
        Queue<Integer> que = new LinkedList<>();

        que.add(N);
        visited[N] = true;

        while(!que.isEmpty()) {
            int p = que.poll();

            for(int i=0; i<3; i++) {
                int next_p = p;
                int plus = 0;
                if(i == 0) {
                    next_p *= move[i];
                }
                else {
                    next_p += move[i];
                    plus = 1;
                }

                if(next_p < 0 || next_p > 100000 || visited[next_p]) continue;

                time[next_p] = time[p] + plus;

                if(next_p == K) {
                    que.clear();
                    break;
                }

                que.add(next_p);
                visited[next_p] = true;
            }
        }

        return time[K];
    }
}