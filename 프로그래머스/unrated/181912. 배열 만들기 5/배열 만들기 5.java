import java.util.*;
class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> list = new ArrayList();
        String sub;
        
        for(int i=0; i<intStrs.length; i++){
            sub = intStrs[i].substring(s,s+l);
            if(k < Integer.parseInt(sub)){
                list.add(Integer.parseInt(sub));
            }
        }
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        
        return answer;
    }
}