import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i : scoville) {
            queue.add(i);
        }
        
        while(true) {
            int num1 = queue.poll();
            if(num1 >= K) break;
            int num2 = queue.poll();
            
            queue.add(num1 + num2*2);
            answer++;
            
            if(queue.size() == 1) {
                if(queue.poll() < K) answer = -1;
                break;
            }
        }
        
        return answer;
    }
}