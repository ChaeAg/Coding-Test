import java.util.*;
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>(); // 잔여 여는 괄호가 들어가는 스택
        int cnt = 0;
        for(char c : s.toCharArray()) {
            if(c == ')') {
                if(stack.isEmpty()) cnt++;
                else stack.pop();
                continue;
            }
            stack.push(c);
        }

        return cnt + stack.size();
    }
}