class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] moves = {{1, 0}, {0, 1}};

        Queue<int[]> que = new ArrayDeque<>();
        int[][] sum = new int[m][n];
        que.add(new int[]{0, 0});
        sum[0][0] = grid[0][0];
        
        while(!que.isEmpty()) {
            int[] p = que.poll();
            int row = p[0];
            int col = p[1];

            for(int[] move : moves) {
                int nr = p[0] + move[0];
                int nc = p[1] + move[1];
                if(nr >= m || nc >= n) continue;

                int nsum = sum[p[0]][p[1]] + grid[nr][nc];
                if(sum[nr][nc] == 0 || sum[nr][nc] > nsum) {
                    sum[nr][nc] = nsum;
                    que.add(new int[]{nr, nc});
                }
            }
        }

        return sum[m-1][n-1];
    }
}