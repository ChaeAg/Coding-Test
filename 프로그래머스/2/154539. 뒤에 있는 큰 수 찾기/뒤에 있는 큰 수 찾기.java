import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int size = numbers.length;
        int[] answer = new int[size];
        Stack<Integer> stack = new Stack<>();
        stack.push(numbers[size-1]);
        
        for(int i=size-2; i>=0; i--) {
            while(!stack.empty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }
            answer[i] = stack.empty() ? -1 : stack.peek();
            stack.push(numbers[i]);
        }
        
        answer[size-1] = -1;
        return answer;
    }
}