import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> numMap = new HashMap();
        
        for(int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }
        
        return numMap.size() <= nums.length / 2 ? numMap.size() : nums.length / 2 ;
    }
}