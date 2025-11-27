import java.util.*;
class Solution {
    Map<Integer, Set<Integer>> loserOwnerMap = new HashMap();
    Map<Integer, Set<Integer>> winnerOwnerMap = new HashMap();
    boolean[] visited;
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        for(int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            
            // 진사람 -> [이긴사람1, 이긴사람2 ...]
            loserOwnerMap.computeIfAbsent(loser, i -> new HashSet()).add(winner); 
            // 이긴사람 -> [진사람1, 진사람2 ...]
            winnerOwnerMap.computeIfAbsent(winner, i -> new HashSet()).add(loser); 
        }
        
        for(int i=1; i<=n; i++) { // 전파
            // 나를 이긴 사람을 이긴 사람도 내가 졌다고 침.
            Set<Integer> winnerSet = loserOwnerMap.get(i);
            if(winnerSet != null) {
                Set<Integer> spreadSet = new HashSet();

                for(int winner : winnerSet) {
                    // dfs
                    visited = new boolean[n+1];
                    dfs(winner, spreadSet, true);
                }
                
                winnerSet.addAll(spreadSet);
            }

            // 내가 이긴 사람한테 진 사람도 내가 이겼다고 침.
            Set<Integer> loserSet = winnerOwnerMap.get(i);
            if(loserSet != null) {
                Set<Integer> spreadSet = new HashSet();

                for(int loser : loserSet) {
                    // dfs
                    visited = new boolean[n+1];
                    dfs(loser, spreadSet, false);
                }
                
                loserSet.addAll(spreadSet);
            }
        }
        
        for(int i=1; i<=n; i++) {
            Set<Integer> winnerSet = loserOwnerMap.get(i);
            Set<Integer> loserSet = winnerOwnerMap.get(i);
            
            int loseCnt = winnerSet == null ? 0 : winnerSet.size();
            int winCnt = loserSet == null ? 0 : loserSet.size();
            
            if(loseCnt + winCnt == n-1) answer++;
        }
        
        return answer;
    }
    
    void dfs(int node, Set<Integer> spreadSet, boolean isWinner) {
        visited[node] = true;
        
        Set<Integer> set = new HashSet();
        
        if(isWinner) set = loserOwnerMap.get(node);
        else set = winnerOwnerMap.get(node);
        
        if(set == null) return;
        
        for(int i : set) {
            if(visited[i]) continue;
            
            spreadSet.add(i);
            dfs(i, spreadSet, isWinner);
        }
    }
}