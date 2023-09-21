import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String[] array = String.valueOf(n).split("");
        
        Arrays.sort(array, Collections.reverseOrder());
        
        for(String s:array) {
            answer *= 10;
            answer += Long.valueOf(s);
        }
        
        return answer;
    }
}