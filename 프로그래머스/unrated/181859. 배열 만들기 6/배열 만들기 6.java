import java.util.*;
class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> list = new ArrayList();
        int idx = 0;
        
        for(int i:arr){
            if(list.size() == 0){
                list.add(i);
                idx++;
            }
            else if(list.get(idx-1) == i){
                list.remove(idx-1);
                idx--;
            }
            else{
                list.add(i);
                idx++;
            }
        }
        if(idx == 0) list.add(-1);
        
        return list;
    }
}