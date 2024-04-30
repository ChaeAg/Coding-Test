import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        List<Long> nums = new ArrayList<>();
        
        for(long i=left; i<=right; i++){
             nums.add(Math.max(i/n, i%n) + 1);
        }
        
        return nums.stream().mapToInt(Long::intValue).toArray();
    }
}