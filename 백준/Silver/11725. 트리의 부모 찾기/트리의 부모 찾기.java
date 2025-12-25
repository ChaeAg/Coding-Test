import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> connects = new HashMap<>();

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            connects.computeIfAbsent(node1, k -> new ArrayList<>()).add(node2);
            connects.computeIfAbsent(node2, k -> new ArrayList<>()).add(node1);
        }

        int[] parents = new int[N + 1];
        parents[1] = 1;

        Queue<Integer> que = new LinkedList<>();
        que.add(1);

        while (!que.isEmpty()) {
            int now = que.poll();

            List<Integer> list = connects.get(now);

            if (list == null) {
                continue;
            }

            for (int node : list) {
                if (parents[node] == 0) {
                    parents[node] = now;
                    que.add(node);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append("\n");
        }

        System.out.print(sb);
    }
}