import java.util.*;
class Solution {    
    public int solution(int n, int[][] edge) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int[] i : edge) {
            int a = i[0];
            int b = i[1];
            
            map.computeIfAbsent(a, s -> new ArrayList<>()).add(b);
            map.computeIfAbsent(b, s -> new ArrayList<>()).add(a);
        }
        
        int[] node = new int[n+1];
        Arrays.fill(node, n+1);
        
        PriorityQueue<Integer> q = new PriorityQueue<>((n1, n2) -> node[n1] - node[n2]);
        
        q.add(1);
        node[1] = 0;
        
        while(!q.isEmpty()) {
            int now_node = q.poll();
            List<Integer> list = map.get(now_node);
            
            for(int i : list) {
                if(node[i] > node[now_node] + 1) {
                    node[i] = node[now_node] + 1;
                    q.add(i);
                }
            }
        }
        
        int max = 0;
        for(int i : node) {
            if(i == n+1) continue;
            max = Math.max(i, max);
        }
        
        
        int answer = 0;
        for(int i : node) {
            if(i == max) answer++;
        } 
        
        
        return answer;
    }
}