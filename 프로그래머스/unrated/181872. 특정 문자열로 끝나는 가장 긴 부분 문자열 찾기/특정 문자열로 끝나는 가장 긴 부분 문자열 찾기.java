class Solution {
    public String solution(String myString, String pat) {
        char[] c = myString.toCharArray();
        
        for(int i=0; i<c.length; i++){
            String answer = "";
            for(int k=0; k<c.length-i; k++){
                answer += String.valueOf(c[k]);
            }
            if(answer.endsWith(pat)){
                return answer;
            }
        }
        
        return "0";
    }
}