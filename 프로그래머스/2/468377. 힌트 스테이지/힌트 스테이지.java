class Solution {
    int[][] cost;
    int[][] hint;
    int[] hintCnt;
    int n, k;
    int minTotal = 1600000;
    public int solution(int[][] cost, int[][] hint) {
        this.cost = cost;
        this.hint = hint;
        n = cost.length;
        k = hint[0].length;
        hintCnt = new int[n];
        
        dfs(1, 0);
        
        return minTotal;
    }
    
    // stage : 1~n
    // cost : int[0~n-1][0~n-1];
    // hint : int[0~n-2][0~k-1]
    // hintCnt : int[0~n-1];
    void dfs(int stage, int totalMoney) {
        totalMoney += cost[stage-1][
            hintCnt[stage-1] > n-1
                ? n-1
                : hintCnt[stage-1]
        ];
        
        if(stage >= n) {
            minTotal = Math.min(minTotal, totalMoney);
            return;
        }
        
        int hintPrice = hint[stage-1][0];
        for(int i=1; i<hint[stage-1].length; i++) {
            hintCnt[hint[stage-1][i] - 1]++;
        }
        dfs(stage+1, totalMoney+hintPrice);
        
        for(int i=1; i<hint[stage-1].length; i++) {
            hintCnt[hint[stage-1][i] - 1]--;
        }
        dfs(stage+1, totalMoney);
    }
}