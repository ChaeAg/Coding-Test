import java.io.*;
import java.util.*;

class Load implements Comparable<Load> {
    int start;
    int to;
    int cost;

    public Load(int start, int to, int cost) {
        this.start = start;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Load o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Load> loads = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            loads.add(new Load(A, B, C));
        }

        Collections.sort(loads);

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        int maxCost = 0;
        int cnt = 0;

        for (Load load : loads) {
            int root1 = find(load.start);
            int root2 = find(load.to);

            if (root1 != root2) {
                union(root1, root2);
                totalCost += load.cost;
                maxCost = Math.max(maxCost, load.cost); // 가장 큰 간선 추적
                cnt++;

                // N-1개 간선이면 MST 완성
                if (cnt == N - 1) {
                    break;
                }
            }
        }

        System.out.print(totalCost - maxCost);
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        parent[x] = y;
    }
}