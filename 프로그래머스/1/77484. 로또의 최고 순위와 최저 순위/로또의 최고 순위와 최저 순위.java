import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        List<Integer> list = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
        int count = 0;
        int zeroCount = 0;
        for(int num : lottos) {
            if(num == 0) zeroCount++;
            else if(list.contains(num)) {
                count++;
            }
        }
        if(count > 1) answer[1] = 7 - count;
        else answer[1] = 6;
        
        if(count + zeroCount > 1) answer[0] = 7 - (count + zeroCount);
        else answer[0] = 6;
        
        return answer;
    }
}