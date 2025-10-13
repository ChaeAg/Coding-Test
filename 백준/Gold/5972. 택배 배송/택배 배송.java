import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            List<int[]> a_connect = map.getOrDefault(A, new ArrayList<>());
            a_connect.add(new int[]{B, C});
            map.put(A, a_connect);

            List<int[]> b_connect = map.getOrDefault(B, new ArrayList<>());
            b_connect.add(new int[]{A, C});
            map.put(B, b_connect);
        }

        System.out.print(bfs(map, N));
    }

    public static int bfs(Map<Integer, List<int[]>> map, int N) {
        int[] distance = new int[50001];
        Arrays.fill(distance, -1);
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        q.add(new int[]{1, 0});
        distance[1] = 0;

        while (!q.isEmpty()) {
            int[] load = q.poll();

            List<int[]> connect_list = map.get(load[0]);

            for (int[] arr : connect_list) {
                if (distance[arr[0]] == -1 || distance[arr[0]] > load[1] + arr[1]) {
                    distance[arr[0]] = load[1] + arr[1];
                    q.add(new int[]{arr[0], distance[arr[0]]});
                }
            }
        }

        return distance[N];
    }
}