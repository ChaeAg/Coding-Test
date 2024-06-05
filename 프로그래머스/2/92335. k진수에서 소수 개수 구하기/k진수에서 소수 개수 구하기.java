import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] arr = String.valueOf(Integer.toString(n, k)).split("0");
        
        for(String s : arr) {
            if(s.isEmpty() || s.equals("1")) continue;
            long num = Long.parseLong(s);
            if(isSosu(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isSosu(long num) {        
        for(long i=2l; i*i<=num; i++) {
            if(num % i == 0) return false;
        }
        
        return true;
    }
}