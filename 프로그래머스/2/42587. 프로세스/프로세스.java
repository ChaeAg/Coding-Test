import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> q = new ArrayDeque<>();
        int max = 0;
        for(int i=0; i<priorities.length; i++) {
            q.offer(i);
            if(max < priorities[i]) max = priorities[i];
        }
        
        int before_idx = -1;
        
        while(before_idx != location) {
            int idx = q.poll();
            
            if(max > priorities[idx]) {
                q.offer(idx);
                continue;
            }
            
            priorities[idx] = 0;
            max = Arrays.stream(priorities).max().getAsInt();
            before_idx = idx;
            answer++;
        }
        
        return answer;
    }
}