import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int num;
    int money;
    List<Integer> route = new ArrayList<>();

    public Node(int num, int money) {
        this.num = num;
        this.money = money;
    }

    void addRoute(int nextNum) {
        route.add(nextNum);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Map<Integer, List<Node>> map = new HashMap<>();

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());

            map.computeIfAbsent(start, k -> new ArrayList<>()).add(
                    new Node(end, money)
            );
        }

        int[] target = new int[2];
        st = new StringTokenizer(br.readLine());
        target[0] = Integer.parseInt(st.nextToken());
        target[1] = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> que = new PriorityQueue<>((Comparator.comparingInt(node -> node.money)));
        int[] result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);

        result[target[0]] = 0;
        Node startNode = new Node(target[0], 0);
        que.add(startNode);
        startNode.addRoute(target[0]);

        List<Integer> resultRoute = new ArrayList<>();

        while (!que.isEmpty()) {
            Node now = que.poll();

            if (now.num == target[1]) {
                break;
            }

            List<Node> list = map.get(now.num);

            if (list == null) {
                continue;
            }

            List<Integer> route = now.route;

            for (Node node : list) {
                if (result[node.num] == Integer.MAX_VALUE
                        || now.money + node.money < result[node.num]) {
                    result[node.num] = now.money + node.money;

                    Node nextNode = new Node(node.num, result[node.num]);
                    que.add(nextNode);

                    nextNode.route = new ArrayList<>(route);
                    nextNode.addRoute(nextNode.num);

                    if (node.num == target[1]) {
                        resultRoute = List.copyOf(nextNode.route);
                    }
                }
            }
        }

        System.out.println(result[target[1]]);
        System.out.println(resultRoute.size());
        for (int i : resultRoute) {
            System.out.print(i + " ");
        }
    }
}