import java.io.*;
import java.util.*;

class Node {
    int num;
    int money;

    Node(int num, int money) {
        this.num = num;
        this.money = money;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        Map<Integer, List<Node>> map = new HashMap<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());

            map.computeIfAbsent(start, k -> new ArrayList<>()).add(new Node(end, money));
        }

        int[] result = new int[V + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        PriorityQueue<Node> que = new PriorityQueue<>(Comparator.comparingInt(o -> o.money));

        result[K] = 0;
        que.add(new Node(K, 0));

        while (!que.isEmpty()) {
            Node node = que.poll();
            List<Node> list = map.get(node.num);
            if (list == null) {
                continue;
            }

            for (Node n : list) {
                if (result[n.num] == Integer.MAX_VALUE || result[n.num] > node.money + n.money) {
                    result[n.num] = node.money + n.money;
                    que.add(new Node(n.num, result[n.num]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            sb.append(result[i] == Integer.MAX_VALUE ? "INF" : result[i]).append("\n");
        }

        System.out.print(sb);
    }
}