import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int min = 0;
        int max = 200000000;
        
        while(min < max) {
            int mid = (min + max) / 2;
            int zero_count = 0;
            for(int i=0; i<stones.length; i++) {
                if(stones[i] - mid > 0) {
                    zero_count = 0;
                }
                else {
                    zero_count++;
                }
                
                if(zero_count == k) {
                    max = mid;
                    break;
                }
            }
            
            if(zero_count < k) {
                min = mid + 1;
            }
        }
        
        return min;
    }
}