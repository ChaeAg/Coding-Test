class Solution {
    public int solution(String number) {
        int answer = 0;
        String[] s = number.split("");
        
        for(int i=0; i<s.length; i++){
            answer += Integer.parseInt(s[i]);
        }
        answer %= 9;
        
        return answer;
    }
}