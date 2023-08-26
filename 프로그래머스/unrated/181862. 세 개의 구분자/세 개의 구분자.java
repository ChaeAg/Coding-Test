import java.util.*;
class Solution {
    public List<String> solution(String myStr) {
        char[] arr = myStr.toCharArray();
        List<String> list = new ArrayList();
        String s = "";
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] != 'a' && arr[i] != 'b' && arr[i] != 'c'){
                s += arr[i];
                if(i == arr.length - 1 && !s.equals("")) list.add(s);
            }
            else if(!s.equals("")){
                list.add(s);
                s = "";
            }
        }
        if(list.size() == 0){
            List<String> empty = Arrays.asList("EMPTY");
            return empty;
        }
        
        return list;
    }
}