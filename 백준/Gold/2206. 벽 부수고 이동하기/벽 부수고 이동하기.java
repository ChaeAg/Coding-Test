import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] strs = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(strs[j]);
            }
        }

        System.out.println(bfs(N, M, map));
    }

    public static int bfs(int N, int M, int[][] map) {
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        que.add(new int[]{0, 0, 1, 0}); // 순서대로 i, j, 거리, 벽뿌심여부(0일때 안뿌신거)

        int[][] noBrokenResultMap = new int[N][M];
        int[][] brokenResultMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(noBrokenResultMap[i], Integer.MAX_VALUE);
            Arrays.fill(brokenResultMap[i], Integer.MAX_VALUE);
        }

        noBrokenResultMap[0][0] = 1;
        brokenResultMap[0][0] = 1;

        while (!que.isEmpty()) {
            int[] now = que.poll();

            if (now[0] == N - 1 && now[1] == M - 1) {
                break;
            }

            for (int[] move : moves) {
                int nextX = now[0] + move[0];
                int nextY = now[1] + move[1];
                int nextDist = now[2] + 1;
                int brokenCond = now[3];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    continue;
                }

                if ((brokenCond == 1 && brokenResultMap[nextX][nextY] != Integer.MAX_VALUE)
                        || (brokenCond == 0 && noBrokenResultMap[nextX][nextY] != Integer.MAX_VALUE)) {
                    continue;
                }

                if (map[nextX][nextY] == 1) { // 벽임
                    if (brokenCond == 1) { // 이미 한 번 벽 뿌셨으면 이 경로는 못옴.
                        continue;
                    }
                    que.add(new int[]{nextX, nextY, nextDist, 1});
                    brokenResultMap[nextX][nextY] = Math.min(brokenResultMap[nextX][nextY], nextDist);
                } else {
                    if (brokenCond == 1) {
                        que.add(new int[]{nextX, nextY, nextDist, 1});
                        brokenResultMap[nextX][nextY] = Math.min(brokenResultMap[nextX][nextY], nextDist);
                    } else {
                        que.add(new int[]{nextX, nextY, nextDist, 0});
                        noBrokenResultMap[nextX][nextY] = Math.min(noBrokenResultMap[nextX][nextY], nextDist);
                    }
                }
            }
        }

        int result = Math.min(noBrokenResultMap[N - 1][M - 1], brokenResultMap[N - 1][M - 1]);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}