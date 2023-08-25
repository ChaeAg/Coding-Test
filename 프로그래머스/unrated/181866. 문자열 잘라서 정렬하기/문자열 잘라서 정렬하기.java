import java.util.*;
class Solution {
    public List<String> solution(String myString) {
        String[] answer = myString.split("x");
        List<String> list = new ArrayList();
        
        for(String i:answer){
            if(!i.equals("")) list.add(i);
        }
        
        list.sort(Comparator.naturalOrder());
        return list;
    }
}