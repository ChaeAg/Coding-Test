import java.util.*;

class Solution {
    int n;
    int[][] computers;
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.n = n;
        this.computers = computers;
        visited = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int num) {
        visited[num] = true;
        
        for(int i=0; i<n; i++) {
            if(num != i && !visited[i] && computers[num][i] == 1) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}