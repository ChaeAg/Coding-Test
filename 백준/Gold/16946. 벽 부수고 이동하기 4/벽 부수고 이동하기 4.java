import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int N, M;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
    static int[][] groupIds;
    static int groupId = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        List<int[]> wallList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 1) {
                    wallList.add(new int[]{i, j});
                }
            }
        }

        groupIds = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(groupIds[i], -1);
        }

        Map<Integer, Integer> cntWithGroup = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (groupIds[i][j] != -1 || map[i][j] != 0) {
                    continue;
                }

                cntWithGroup.put(groupId, groupingBFS(i, j));
                groupId++;
            }
        }

        int[][] result = new int[N][M];
        for (int[] wall : wallList) {
            int x = wall[0], y = wall[1];
            int cnt = 1;
            Set<Integer> visitedGroup = new HashSet<>();

            for (int[] move : moves) {
                int next_x = x + move[0];
                int next_y = y + move[1];

                if (next_x < 0 || next_x >= N || next_y < 0 || next_y >= M || map[next_x][next_y] != 0
                        || !visitedGroup.add(groupIds[next_x][next_y])) {
                    continue;
                }

                cnt += cntWithGroup.get(groupIds[next_x][next_y]);
            }

            result[x][y] = cnt % 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int[] arr : result) {
            for (int i : arr) {
                sb.append(i);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static int groupingBFS(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});
        groupIds[x][y] = groupId;
        int groupCnt = 1;

        while (!que.isEmpty()) {
            int[] now = que.poll();

            for (int[] move : moves) {
                int next_x = now[0] + move[0];
                int next_y = now[1] + move[1];

                if (next_x < 0 || next_x >= N || next_y < 0 || next_y >= M ||
                        map[next_x][next_y] != 0 || groupIds[next_x][next_y] != -1) {
                    continue;
                }

                groupIds[next_x][next_y] = groupId;
                groupCnt++;
                que.add(new int[]{next_x, next_y});
            }
        }

        return groupCnt;
    }
}