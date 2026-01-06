import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        Queue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            que.add(new int[]{a, b, c});
        }

        int totalCost = 0;

        for (int i = 0; i < M; i++) {
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