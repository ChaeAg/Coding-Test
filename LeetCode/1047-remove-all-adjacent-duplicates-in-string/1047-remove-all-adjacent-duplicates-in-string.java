import java.util.*;
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            
            boolean cond = true;
            while(!stack.isEmpty()) {
                if(stack.peek() == c) {
                    stack.pop();
                    cond = false;
                } else {
                    if(cond) stack.push(c);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}