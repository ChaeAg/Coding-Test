import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for(int k=l; k<=r; k++){
            String str = k + "";
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == 48 || str.charAt(i) == 53){
                count++;
                }
            }
            if(count == str.length()){
                list.add(k);
            }
            count = 0;
        }
        int[] answer = list.stream().mapToInt(i->i).toArray();
        int[] empty = {-1};
        
        if(answer.length == 0) return empty;
        else return answer;
    }
}