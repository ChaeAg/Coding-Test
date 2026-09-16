import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long simsaCount = (long)times.length;
        long end = 1000000000L * n / simsaCount;
        long start = 0L;
        long mid = 0L;
        
        while(start < end) {
            mid = (start + end) / 2;
            
            long c = 0L;
            for(int t : times) {
                c += mid / t;
            }
            
            if(c < n) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        
        return start;
    }
}