import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // map<노드번호, map<연결노드번호, 거리>>
    static Map<Integer, Map<Integer, Integer>> connected = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            // 연결 상태 저장
            Map<Integer, Integer> map1 = connected.getOrDefault(node1, new HashMap<>());
            map1.put(node2, distance);
            connected.put(node1, map1);
            Map<Integer, Integer> map2 = connected.getOrDefault(node2, new HashMap<>());
            map2.put(node1, distance);
            connected.put(node2, map2);
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            bfs(node1, node2);
        }

        System.out.print(sb);
    }

    public static void bfs(int node1, int node2) {
        int[] distance = new int[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node1);

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for(int connectNode : connected.get(node).keySet()) {
                if(connectNode == node1) continue;
                if(connectNode == node2) { // 도착
                    sb.append(distance[node] + connected.get(node).get(connectNode)).append("\n");
                    queue.clear();
                    break;
                }
                if(distance[connectNode] == 0) {
                    distance[connectNode] = distance[node] + connected.get(node).get(connectNode);
                    queue.add(connectNode);
                }
            }
        }
    }
}