class Solution {
    public String solution(String n_str) {
        String answer = "";
        int idx = 0;
        while(n_str.charAt(idx) == '0') idx++;
        
        for(int i=idx; i<n_str.length(); i++){
            answer += n_str.charAt(i);
        }
        return answer;
    }
}