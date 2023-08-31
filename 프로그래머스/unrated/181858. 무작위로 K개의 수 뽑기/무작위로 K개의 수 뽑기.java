import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        int idx = 1;
        boolean cond;
        answer[0] = arr[0];
        
        for(int i=1; i<arr.length; i++){
            cond = true;
            for(int j=0; j<idx; j++){
                if(arr[i] == answer[j]) cond = false;
            }
            if(cond) answer[idx++] = arr[i];
            if(idx == k) return answer;
        }
        
        for(int i=idx; i<k; i++) answer[i] = -1;
        return answer;
    }
}