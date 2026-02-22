import java.util.*;
class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int d, n;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        d = destination;
        this.n = n;
        
        for(int[] road : roads) {
            map.computeIfAbsent(road[0], m -> new ArrayList<>()).add(road[1]);
            map.computeIfAbsent(road[1], m -> new ArrayList<>()).add(road[0]);
        }
        
        for(int i=0; i<sources.length; i++) {
            answer[i] = sources[i] == d ? 0 : bfs(sources[i]);
        }
        
        return answer;
    }
    
    int bfs(int source) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{source, 0});
        boolean[] visited = new boolean[n+1];
        visited[source] = true;
        
        while(!que.isEmpty()) {
            int[] now = que.poll();
            
            List<Integer> connect = map.get(now[0]);
            if(connect == null) continue;
            
            for(int i : connect) {
                if(visited[i]) continue;
                if(i == d) return now[1]+1;
                
                que.add(new int[]{i, now[1] + 1});
                visited[i] = true;
            }
        }
        
        return -1;
    }
}