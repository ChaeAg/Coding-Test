import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        Arrays.sort(times);
        
        long left = times[0];
        long right = (long)times[times.length-1] * n;
        
        while(left <= right) {
            long mid = (left+right) / 2;
            long cnt = 0;
            
            for(int t : times) {
                cnt += mid / t;    
            }
            
            if(cnt < n) {
                left = mid+1;
            }
            else {
                answer = Math.min(answer, mid);
                right = mid-1;
            }
        }
        
        return answer;
    }
}