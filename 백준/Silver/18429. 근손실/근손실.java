import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] weights;
    static int count = 0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        weights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visited = new boolean[N];
        dfs(500, 0);
        System.out.print(count);
    }

    static void dfs(int muscle, int depth) {
        if(depth == N) {
            count++;
            return;
        }

        for(int i=0; i<weights.length; i++) {
            if(!visited[i] && muscle + weights[i] - K >= 500) {
                visited[i] = true;
                dfs(muscle + weights[i] - K, depth + 1);
                visited[i] = false;
            }
        }
    }
}