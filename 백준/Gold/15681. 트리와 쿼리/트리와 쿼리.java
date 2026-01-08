import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] tree;
    static int[] subtreeSize;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        // 한 번만 DFS를 수행하여 모든 서브트리 크기 계산
        subtreeSize = new int[N + 1];
        visited = new boolean[N + 1];
        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            sb.append(subtreeSize[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.print(sb);
    }

    static int dfs(int node) {
        visited[node] = true;
        int size = 1; // 자기 자신

        for (int child : tree[node]) {
            if (!visited[child]) {
                size += dfs(child); // 자식 서브트리 크기 더하기
            }
        }

        subtreeSize[node] = size;
        return size;
    }
}