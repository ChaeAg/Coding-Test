import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Long> sumSet = new HashSet();
        for(int i=0; i<numbers.length - 1; i++) {
            for(int k=i+1; k<numbers.length; k++) {
                sumSet.add(Long.valueOf(numbers[i]) + Long.valueOf(numbers[k]));
            }
        }
        
        return sumSet.stream().mapToInt(Long::intValue).sorted().toArray();
    }
}