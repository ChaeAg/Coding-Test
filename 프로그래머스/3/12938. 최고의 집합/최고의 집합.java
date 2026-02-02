import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        int defaultValue = s / n;
        if(defaultValue == 0) {
            return new int[]{-1};
        }
        
        Arrays.fill(answer, defaultValue);
        
        int namugi = s % n;
        int idx = n - 1;
        while(namugi-- > 0) {
            answer[idx--]++;
            
            if(idx == -1) idx = n-1;
        }
        
        return answer;
    }
}