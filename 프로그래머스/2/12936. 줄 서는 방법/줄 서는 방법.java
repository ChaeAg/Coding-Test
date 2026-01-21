import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        long[] factorial = new long[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        
        List<Integer> nums = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            nums.add(i);
        }
        
        k--;
        
        for(int i=0; i<n; i++) {
            int first = n - 1 - i; // 현재 계산하는 자릿수
            
            answer[i] = nums.remove((int)(k / factorial[first]));
            
            k %= factorial[first];
        }
        
        return answer;
    }
}