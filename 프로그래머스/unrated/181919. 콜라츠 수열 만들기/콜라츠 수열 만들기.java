import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        int[] answer= {};
        list.add(n);
        
        for(int i=1; n!=1; i++){
            if(n % 2 == 0){
                n = n / 2;
                list.add(n);
            }
            else{
                n = 3 * n + 1;
                list.add(n);
            }
        }
        
        answer = list.stream().mapToInt(i->i).toArray();
            
        return answer;
    }
}