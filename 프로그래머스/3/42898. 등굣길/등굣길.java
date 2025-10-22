import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        List<int[]> puddle_list = new ArrayList<>();
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] p : puddles) {
            Set<Integer> tmp = map.getOrDefault(p[0], new HashSet<>());
            tmp.add(p[1]);
            map.put(p[0], tmp);
        }
        
        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(map.get(i) != null && map.get(i).contains(j)) {
                    dp[i][j] = -1;
                    continue;
                }
                
                if(dp[i][j-1] != -1) dp[i][j] = (dp[i][j] + dp[i][j-1]) % 1000000007;
                
                if(dp[i-1][j] != -1) dp[i][j] = (dp[i][j] + dp[i-1][j]) % 1000000007;
            }
        }
        
        return dp[m][n] % 1000000007;
    }
}