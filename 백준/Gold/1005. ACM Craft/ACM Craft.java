import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, Set<Integer>> map;
    static int[] times;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long T = Long.parseLong(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            times = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }

            map = new HashMap<>();
            memo = new int[N + 1];
            Arrays.fill(memo, Integer.MAX_VALUE);

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int need = Integer.parseInt(st.nextToken());
                int tower = Integer.parseInt(st.nextToken());

                map.computeIfAbsent(tower, n -> new HashSet<>()).add(need);
            }

            int target = Integer.parseInt(br.readLine());
            sb.append(getBuildTime(target)).append("\n");
        }
        System.out.print(sb);
    }

    static int getBuildTime(int nowTower) {
        Set<Integer> needTowers = map.get(nowTower);

        if (needTowers == null) {
            return times[nowTower];
        }

        int maxTime = 0;
        for (int needTower : needTowers) {
            if (memo[needTower] == Integer.MAX_VALUE) {
                maxTime = Math.max(maxTime, getBuildTime(needTower));
            } else {
                maxTime = Math.max(maxTime, memo[needTower]);
            }
        }

        int totalTime = maxTime + times[nowTower];
        memo[nowTower] = totalTime;
        return totalTime;
    }
}