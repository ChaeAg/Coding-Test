import java.util.*;
class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int[][] number = new int[n][n];
        Map<Integer, Integer> numberWithSize = new HashMap<>();
        int numSeq = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && number[i][j] == 0) { // 첫방문이고 땅이 있음
                    Queue<int[]> que = new ArrayDeque<>();
                    boolean[][] visited = new boolean[n][n];
                    int size = 1;
                    numSeq++;
                    number[i][j] = numSeq;
                    que.add(new int[]{i, j, numSeq});
                    visited[i][j] = true;

                    while (!que.isEmpty()) {
                        int[] now = que.poll();

                        for (int[] m : moves) {
                            int nx = now[0] + m[0];
                            int ny = now[1] + m[1];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n
                                    || visited[nx][ny] || grid[nx][ny] == 0) {
                                continue;
                            }

                            que.add(new int[]{nx, ny, now[2]});
                            visited[nx][ny] = true;
                            number[nx][ny] = now[2];
                            size++;
                        }
                    }

                    numberWithSize.put(numSeq, size);
                }
            }
        }

        int maxSize = 0;
        for(int s : numberWithSize.values()) {
            maxSize = Math.max(maxSize, s);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1) continue;

                Set<Integer> numSet = new HashSet<>();
                for (int[] m : moves) {
                    int nx = i + m[0];
                    int ny = j + m[1];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n
                            || number[nx][ny] == 0) {
                        continue;
                    }

                    numSet.add(number[nx][ny]);
                }

                int sizeSum = 1; // 자기 자신에 땅을 생성
                for (int num : numSet) {
                    sizeSum += numberWithSize.get(num);
                }
                maxSize = Math.max(maxSize, sizeSum);
            }
        }

        return maxSize;
    }
}