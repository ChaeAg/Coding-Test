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
        BFS(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    public static void BFS(int N, int K) {
        int len = N < K ? K * 2 + 1 : N + 1;
        int[] time = new int[len];
        int[] back = new int[len];
        boolean[] visited = new boolean[len];
        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        visited[N] = true;

        while(!que.isEmpty()) {
            int zum = que.poll();

            for(int move : new int[]{zum + 1, zum - 1, zum * 2}) {
                if(move < 0 || move >= len) continue;

                if (!visited[move]) {
                    visited[move] = true;
                    time[move] = time[zum] + 1;
                    back[move] = zum;
                    que.add(move);
                }
            }
        }

        System.out.println(time[K]);
        int end = K;
        StringBuilder sb = new StringBuilder();
        while(end != N) {
            sb.insert(0, end+" ");
            end = back[end];
        }
        sb.insert(0, N+" ");
        System.out.print(sb);
    }
}