import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        int len = sequence.length;
        int[] arr1 = Arrays.copyOf(sequence, len);
        int[] arr2 = Arrays.copyOf(sequence, len);
        
        int cond1 = 1;
        for(int i=0; i<len; i++) {
            arr1[i] *= cond1;
            cond1 *= -1;
            arr2[i] *= cond1;
        }
        
        long[] dp1 = new long[len+1];
        long[] dp2 = new long[len+1];
        long answer = 0;
        for(int i=1; i<=len; i++) {
            dp1[i] = Math.max(dp1[i-1] + arr1[i-1], arr1[i-1]);
            dp2[i] = Math.max(dp2[i-1] + arr2[i-1], arr2[i-1]);
            answer = Math.max(answer, Math.max(dp1[i], dp2[i]));
        }
        
        return answer;
    }
}