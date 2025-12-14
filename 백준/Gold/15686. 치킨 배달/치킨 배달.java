import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int N, M;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    houses.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        combi(new ArrayList<>(), 0);

        System.out.print(min);
    }

    static void combi(List<Integer> choiceChickenIdxs, int start) {
        if (choiceChickenIdxs.size() == M) {
            int dis = disCheck(choiceChickenIdxs);
            min = Math.min(min, dis);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            if (choiceChickenIdxs.contains(i)) {
                continue;
            }

            choiceChickenIdxs.add(i);

            combi(choiceChickenIdxs, i + 1);

            choiceChickenIdxs.remove((Object) i);
        }
    }

    static int disCheck(List<Integer> choiceChickenIdxs) {
        int minSum = 0;

        for (int[] house : houses) {
            int minDis = Integer.MAX_VALUE;
            for (int choiceChickenIdx : choiceChickenIdxs) {
                int[] chicken = chickens.get(choiceChickenIdx);

                int dis = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);

                minDis = Math.min(minDis, dis);
            }
            minSum += minDis;
        }

        return minSum;
    }
}