class Solution {
    int[][] moves = {{-1, -1}, {-1, 1}}; // 왼위, 오위 -> 이미 퀸을 둔 영역 대각선 확인
    boolean[] lineUsed;
    boolean[][] map;
    int n, result = 0;
    public int solution(int n) {
        this.n = n;
        lineUsed = new boolean[n]; // 해당 세로 라인 사용했는지 -> lineUsed[0]: 첫번째 세로줄에 퀸이 있는가?
        map = new boolean[n][n];
        
        dfs(0);
        
        return result;
    }
    
    void dfs(int garoLine) {
        if (garoLine == n) { // 퀸 무사히 다 놓음!
            result++;
            return;
        }

        nextSeroLabel:
        for (int sero = 0; sero < n; sero++) {
            if (lineUsed[sero]) {
                continue;
            }

            for (int[] move : moves) {
                int nextGaro = garoLine + move[0];
                int nextSero = sero + move[1];

                while (nextGaro >= 0 && nextSero >= 0 && nextSero < n) {
                    if (map[nextGaro][nextSero]) {
                        continue nextSeroLabel;
                    }

                    nextGaro += move[0];
                    nextSero += move[1];
                }
            }

            map[garoLine][sero] = true;
            lineUsed[sero] = true;
            dfs(garoLine + 1);
            map[garoLine][sero] = false;
            lineUsed[sero] = false;
        }
    }
}