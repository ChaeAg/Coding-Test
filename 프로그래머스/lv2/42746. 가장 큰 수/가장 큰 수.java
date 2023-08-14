import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String temp;
        String[] s = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++)
            s[i] = String.valueOf(numbers[i]);
        
        Arrays.sort(s, Comparator.reverseOrder());
        
        int k;
        for(int i=0; i<s.length; i++){
            if(i > 0){
                k = i;
                while(Integer.parseInt(s[k]+s[k-1]) > Integer.parseInt(s[k-1]+s[k])){
                    temp = s[k];
                    s[k] = s[k-1];
                    s[k-1] = temp;
                    k--;
                    if(k == 0) break;
                }
            }  
        }
        for(int i=0; i<s.length; i++)
            answer += s[i];
        
        if(s[0].equals("0"))
            return "0";
        
        return answer;
    }
}