class Solution {
    public int solution(String myString, String pat) {
        int result = 0;
        
        for(int i=0; i<myString.length(); i++){
            if(myString.indexOf(pat, i) != -1) {
                i = myString.indexOf(pat, i);
                result++;
            }
        }
        
        return result;
    }
}