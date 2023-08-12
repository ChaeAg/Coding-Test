import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        List<String> list = new ArrayList();
        int idx = 0, cond = 0;
        
        String[] splitresult = my_string.split(" ");
        
        for(int i=0; i<splitresult.length; i++){
            if(!splitresult[i].isEmpty()) list.add(splitresult[i]);  
        }
        String[] answer = new String[list.size()];
        for(int k=0; k<answer.length; k++) answer[k] = list.get(k);
        
        return answer;
    }
}