import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        List<Integer> lo = Arrays.stream(lost)
            .boxed()
            .sorted()
            .collect(Collectors.toList());
        List<Integer> re = Arrays.stream(reserve)
            .boxed()
            .sorted()
            .collect(Collectors.toList());
        
        for(int i : lost) {
            if(re.contains(i)) {
                answer++;
                lo.remove(lo.indexOf(i));
                re.remove(re.indexOf(i));
            }
        }
        
        for(int i : lo) {
            if(re.contains(i-1)) {
                answer++;
                re.remove(re.indexOf(i-1));
            }
            else if(re.contains(i+1)) {
                answer++;
                re.remove(re.indexOf(i+1));
            }
        }
        
        return answer;
    }
}