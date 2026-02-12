import java.util.*;
class Solution {
    public int solution(int[][] land) {
        int[][] moves = {{-1,0},{1,0},{0,-1},{0,1}};
        int n = land.length;
        int m = land[0].length;
        int[][] numbering = new int[n][m];
        int[] groupSize = new int[n * m + 1];
        int number = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 처음 만난 석유 덩어리
                if (land[i][j] == 1 && numbering[i][j] == 0) {
                    number++;
                    int size = 0;
                    Queue<int[]> que = new ArrayDeque<>();
                    que.add(new int[]{i, j});
                    numbering[i][j] = number;
                    
                    while (!que.isEmpty()) {
                        int[] cur = que.poll();
                        size++;
                        for (int[] mv : moves) {
                            int nx = cur[0] + mv[0];
                            int ny = cur[1] + mv[1];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m
                                    && land[nx][ny] == 1 && numbering[nx][ny] == 0) {
                                numbering[nx][ny] = number;
                                que.add(new int[]{nx, ny});
                            }
                        }
                    }
                    groupSize[number] = size;
                }
            }
        }

        int maxCnt = 0;
        for (int j = 0; j < m; j++) {
            Set<Integer> set = new HashSet<>();
            int colCnt = 0;
            for (int i = 0; i < n; i++) {
                int gid = numbering[i][j];
                if (gid != 0 && set.add(gid)) {
                    colCnt += groupSize[gid];
                }
            }
            maxCnt = Math.max(maxCnt, colCnt);
        }
        return maxCnt;
    }
}