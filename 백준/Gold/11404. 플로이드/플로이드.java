import java.io.*;
import java.util.*;

class Edge {
    int to;
    int cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

public class Main {
    static ArrayList<Edge>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        arr = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        StringTokenizer st;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr[start].add(new Edge(end, cost));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int[] costs = dic(i, n);

            for (int k = 1; k <= n; k++) {
                sb.append(costs[k] == Integer.MAX_VALUE ? 0 : costs[k]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static int[] dic(int start, int n) {
        PriorityQueue<Edge> que = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

        que.add(new Edge(start, 0));

        int[] costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[start] = 0;

        while (!que.isEmpty()) {
            Edge nowEdge = que.poll();

            List<Edge> connects = arr[nowEdge.to];

            if (connects.isEmpty()) {
                continue;
            }

            for (Edge e : connects) {
                if (costs[e.to] > nowEdge.cost + e.cost) {
                    costs[e.to] = nowEdge.cost + e.cost;
                    que.add(new Edge(e.to, costs[e.to]));
                }
            }
        }

        return costs;
    }
}