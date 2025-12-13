import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[][] moneys = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(moneys[i], Integer.MAX_VALUE);
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());

            map.computeIfAbsent(start, k -> new ArrayList<>()).add(end);
            if (moneys[start][end] > money) {
                moneys[start][end] = money;
            }
        }

        st = new StringTokenizer(br.readLine());
        int targetStart = Integer.parseInt(st.nextToken());
        int targetEnd = Integer.parseInt(st.nextToken());

        if (targetStart == targetEnd) {
            System.out.print(0);
            return;
        }

        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int[] search = new int[N + 1];
        que.add(new int[]{targetStart, 0});

        Arrays.fill(search, -1);

        while (!que.isEmpty()) {
            int[] now = que.poll();
            int nowIdx = now[0];
            int m = now[1];

            List<Integer> list = map.get(nowIdx);

            if (list == null) {
                continue;
            }

            for (int i : list) {
                if (search[i] == -1 || search[i] > m + moneys[nowIdx][i]) {
                    search[i] = m + moneys[nowIdx][i];
                    que.add(new int[]{i, search[i]});
                }
            }
        }

        System.out.print(search[targetEnd]);
    }
}