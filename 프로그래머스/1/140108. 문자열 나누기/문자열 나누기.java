class Solution {
    public int solution(String s) {
        int answer = 0;
        int sameCount = 0;
        int differentCount = 0;
        char first = s.charAt(0);
        
        for(int i=0; i<s.length(); i++) {
            if(sameCount == 0 && differentCount == 0) {
                first = s.charAt(i);
            }
            if(s.charAt(i) == first) sameCount++;
            else differentCount++;
            
            if(sameCount == differentCount) {
                answer++;
                sameCount = 0;
                differentCount = 0;
            }
        }
        
        return sameCount == 0 ? answer : answer + 1;
    }
}