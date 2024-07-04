import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int[] cheolsu = new int[10001];
        int[] brother = new int[10001];
        int c_count = 0;
        int b_count = 0;
        for(int t : topping) {
            if(cheolsu[t] == 0) c_count++;
            cheolsu[t]++;
        }
        
        for(int i=topping.length-1; i>0; i--) {
            int t = topping[i];
            if(brother[t] == 0) b_count++;
            brother[t]++;
            cheolsu[t]--;
            if(cheolsu[t] == 0) c_count--;
            if(b_count == c_count) answer++;
        }
        
        return answer;
    }
}