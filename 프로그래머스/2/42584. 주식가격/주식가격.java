import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> idx_stack = new Stack<>();
        idx_stack.push(0);

        int idx = 1;
        boolean done = false;
        int count = 0;
        while(count < prices.length) {
            if(idx_stack.isEmpty() || !done && idx < prices.length && prices[idx_stack.peek()] <= prices[idx]) {
                idx_stack.push(idx);
                idx++;
                continue;
            }
            if(idx == prices.length) {
                done = true;
                idx--;
            }
            int pop_idx = idx_stack.pop();
            int un_down_time = idx - pop_idx;
            answer[pop_idx] = un_down_time;
            count++;
        }
        
        return answer;
    }
}