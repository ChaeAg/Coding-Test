import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {        
        int[] sortArray = Arrays.stream(d).sorted().toArray();
        int sum = 0;
        int count = 0;
        for(int i : sortArray) {
            if(sum + i > budget) break;
            sum += i;
            count++;
        }
        
        return count;
    }
}