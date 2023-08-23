class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int stack = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') stack++;
            else if(s.charAt(i) == ')') stack--;

            if(stack < 0) return answer;
        }
        if(stack != 0) return answer;
        
        answer = true;
        return answer;
    }
}