import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> que = new PriorityQueue((o1, o2) -> (int)o2 - (int)o1);
        
        for(int work : works) {
            que.add(work);
        }
        
        while(n-- > 0 && !que.isEmpty()) {
            int now = que.poll();
            int next = now - 1;
            
            if(next == 0) continue;

            que.add(next);
        }
        
        long answer = 0;
        while(!que.isEmpty()) {
            answer += Math.pow(que.poll(), 2);
        }
        
        return answer;
    }
}