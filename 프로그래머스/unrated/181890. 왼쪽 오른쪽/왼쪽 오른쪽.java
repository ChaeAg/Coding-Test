import java.util.*;
class Solution {
    public List<String> solution(String[] str_list) {
        List<String> list = new ArrayList();
        int idx = 0;
        
        for(String s:str_list){
            if(s.equals("l")){
                for(int i=0; i<idx; i++){
                    list.add(str_list[i]);
                }
                break;
            }
            else if(s.equals("r")){
                for(int i=idx+1; i<str_list.length; i++){
                    list.add(str_list[i]);
                }
                break;
            }
            idx++;
        }
        
        return list;
    }
}