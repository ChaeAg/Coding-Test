import java.io.*;
import java.util.*;

class Main {
    static Map<Integer, List<Integer>> up_map = new HashMap<>();
    static Map<Integer, List<Integer>> down_map = new HashMap<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            List<Integer> list = down_map.getOrDefault(n1, new ArrayList<>());
            list.add(n2);
            down_map.put(n1, list);

            list = up_map.getOrDefault(n2, new ArrayList<>());
            list.add(n1);
            up_map.put(n2, list);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i, 0);
            dfs(i, 1);
            int cnt = N;
            for (boolean v : visited) if (v) cnt--;
            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }

    public static void dfs(int start, int cond) {
        visited[start] = true;
        List<Integer> connect;
        
        if (cond == 0) {
            connect = up_map.getOrDefault(start, new ArrayList<>());
        } 
        else {
            connect = down_map.getOrDefault(start, new ArrayList<>());
        }

        for (int i : connect) {
            if (visited[i]) continue;
            dfs(i, cond);
        }
    }
}