import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int min = 100;
        
        array = Arrays.stream(array)
            .boxed()
            .sorted(Collections.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
        
        for(int num : array) {
            if(num - n <= 0 && (num - n) * -1 <= min) {
                min = (num - n) * -1;
                answer = num;
            }
            else if(num - n >= 0 && num - n <= min) {
                min = num - n;
                answer = num;
            }
        }
        
        return answer;
    }
}