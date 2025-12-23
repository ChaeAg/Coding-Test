import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Edge {
    int to;
    int money;

    public Edge(int to, int money) {
        this.to = to;
        this.money = money;
    }
}

public class Main {
    static int target;
    static List<Edge>[] arr;
    static int money;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());

            arr[start].add(new Edge(end, money));
            arr[end].add(new Edge(start, money));
        }

        int maxNode = 0;
        int max = 0;
        for (int i = 2; i <= n; i++) { // 루트 노드에서 가장 거리가 먼 노드 찾기
            visited = new boolean[n + 1];
            visited[1] = true;

            target = i;
            dfs(1, 0);
            if (max < money) {
                max = money;
                maxNode = i;
            }
        }

        max = 0;
        for (int i = 1; i <= n; i++) { // 가장 거리가 먼 노드에서 가장 거리가 먼 노드 찾기
            if (i == maxNode) {
                continue;
            }

            visited = new boolean[n + 1];
            visited[maxNode] = true;

            target = i;
            dfs(maxNode, 0);

            max = Math.max(max, money);
        }

        System.out.print(max);
    }

    static void dfs(int now, int sum) {
        List<Edge> edges = arr[now];
        if (edges == null) {
            return;
        }

        for (Edge e : edges) {
            if (e.to == target) {
                money = sum + e.money;
                return;
            }

            if (visited[e.to]) {
                continue;
            }

            visited[e.to] = true;
            dfs(e.to, sum + e.money);
            visited[e.to] = false;
        }
    }
}