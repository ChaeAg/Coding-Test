import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        Queue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            que.add(new int[]{A, B, C});
        }

        int totalCost = 0;

        for (int i = 0; i < E; i++) {
            int[] now = que.poll();

            int root1 = find(now[0]);
            int root2 = find(now[1]);

            if (root1 != root2) {
                totalCost += now[2];
                union(root1, root2);
            }
        }

        System.out.print(totalCost);
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