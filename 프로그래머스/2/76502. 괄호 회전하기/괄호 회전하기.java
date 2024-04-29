import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++) {
            String new_str = s.substring(i) + s.substring(0, i);
            Stack<String> stack = new Stack<String>();
            boolean isPossible = true;
            
            for(String str : new_str.split("")) {
                if(str.equals("(") || str.equals("{") || str.equals("[")) {
                    stack.push(str);
                }
                else {
                    if(stack.isEmpty()) {
                        isPossible = false;
                        break;
                    }
                    String top = stack.pop();
                    if(str.equals(")") && !top.equals("(")) {
                        isPossible = false;
                        break;
                    }
                    else if(str.equals("}") && !top.equals("{")) {
                        isPossible = false;
                        break;
                    }
                    else if(str.equals("]") && !top.equals("[")) {
                        isPossible = false;
                        break;
                    }
                }
            }
            
            if(!stack.isEmpty()) isPossible = false;
    
            if(isPossible) answer++;
        }
        
        return answer;
    }
}