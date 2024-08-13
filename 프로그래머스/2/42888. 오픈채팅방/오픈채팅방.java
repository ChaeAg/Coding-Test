import java.util.*;
class Solution {
    String[] format = {"%s님이 들어왔습니다.", "%s님이 나갔습니다."};
    
    public String[] solution(String[] record) {
        Map<String, String> nick = new HashMap<>();
        
        for(String str : record) {
            String[] temp = str.split(" ");
            
            if(!temp[0].equals("Leave")) {
                nick.put(temp[1], temp[2]);
            }
        }
    
        List<String> result = new ArrayList<>();
        
        for(String str : record) {
            String[] temp = str.split(" ");
            
            if(temp[0].equals("Enter")) {
                result.add(String.format(format[0], nick.get(temp[1])));
            }
            else if(temp[0].equals("Leave")) {
                result.add(String.format(format[1], nick.get(temp[1])));
            }
        }
        
        return result.toArray(new String[result.size()]);
    }
}