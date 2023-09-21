class Solution {
    public int solution(String s) {
        int answer;
        
        switch(s.charAt(0)) {
            case '+':
                answer = Integer.valueOf(s.substring(1));
                break;
            case '-':
                answer = -(Integer.valueOf(s.substring(1)));
                break;
            default:
                answer = Integer.valueOf(s);
        }
        
        return answer;
    }
}