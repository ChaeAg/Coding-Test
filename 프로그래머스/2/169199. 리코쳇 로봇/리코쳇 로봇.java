import java.util.*;
class Solution {
    public int solution(String[] board) {
        int n = board.length;
        int len = board[0].length();
        int[] start = new int[2];
        String[][] b = new String[n][len];

        for (int i = 0; i < n; i++) {
            b[i] = board[i].split("");
            for (int j = 0; j < len; j++) {
                if (b[i][j].equals("R")) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        return bfs(n, len, b, start);
    }

    int bfs(int n, int len, String[][] board, int[] start) {
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        boolean[][] visited = new boolean[n][len];
        Queue<int[]> que = new ArrayDeque<>();

        que.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!que.isEmpty()) {
            int[] now = que.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now[0];
                int nextY = now[1];
                int moveCnt = now[2];

                while (true) {
                    nextX += moves[i][0];
                    nextY += moves[i][1];

                    if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= len) {
                        break;
                    }

                    if (board[nextX][nextY].equals("D")) {
                        if (i < 2) {
                            nextX -= moves[i][0];
                        } else {
                            nextY -= moves[i][1];
                        }
                        break;
                    }

                    if (((i < 2 && (nextX == 0 || nextX == n - 1))
                            || (i >= 2 && (nextY == 0 || nextY == len - 1)))) {
                        break;
                    }
                }

                moveCnt++;

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= len) {
                    continue;
                }

                if (board[nextX][nextY].equals("G")) {
                    return moveCnt;
                }

                if (!board[nextX][nextY].equals(".") || visited[nextX][nextY]) {
                    continue;
                }

                visited[nextX][nextY] = true;
                que.add(new int[]{nextX, nextY, moveCnt});
            }
        }

        return -1;
    }
}