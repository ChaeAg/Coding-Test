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
    static int[] moneys;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            String nextInput = st.nextToken();
            while (!"-1".equals(nextInput)) {
                int end = Integer.parseInt(nextInput);
                int money = Integer.parseInt(st.nextToken());

                arr[start].add(new Edge(end, money));

                nextInput = st.nextToken();
            }
        }

        int maxNode = 0;
        int max = 0;
        moneys = new int[n + 1];
        moneys[1] = 0;

        dfs(1, 0);

        for (int i = 2; i <= n; i++) {
            if (max < moneys[i]) {
                max = moneys[i];
                maxNode = i;
            }
        }
        
        max = 0;
        moneys = new int[n + 1];
        moneys[maxNode] = 0;
        
        dfs(maxNode, 0);

        for (int i = 1; i <= n; i++) {
            if (i == maxNode) {
                continue;
            }
            if (max < moneys[i]) {
                max = moneys[i];
            }
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

            if (moneys[e.to] != 0) {
                continue;
            }

            moneys[e.to] = sum + e.money;
            dfs(e.to, sum + e.money);
        }
    }
}