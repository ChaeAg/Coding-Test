import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++) {
            List<Integer> arr = new ArrayList();
            for(int k=commands[i][0]-1; k<commands[i][1]; k++) {
                arr.add(array[k]);
            }
            Collections.sort(arr);
            answer[i] = arr.get(commands[i][2] - 1);
        }
        
        return answer;
    }
}