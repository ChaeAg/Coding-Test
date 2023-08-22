class Solution {
    public int[] solution(String myString) {
        String[] s = myString.split("x");
        int[] answer;
        
        if(myString.substring(myString.length()-1, 
                              myString.length()).equals("x")){
            answer = new int[s.length+1];
            for(int i=0; i<s.length; i++){
                answer[i] = s[i].length();
                if(i == s.length) answer[i] = 0;
            }
        }
        else{
            answer = new int[s.length];
            for(int i=0; i<s.length; i++){
            answer[i] = s[i].length();
            }
        }
        
        
        
        return answer;
    }
}