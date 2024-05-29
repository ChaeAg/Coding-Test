import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> str1_list = new ArrayList<>();
        List<String> str2_list = new ArrayList<>();

        for(int i=0; i<str1.length()-1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i+1);
            if(!Character.isAlphabetic(c1) || !Character.isAlphabetic(c2)) continue;                
            str1_list.add(String.valueOf(c1 +""+ c2).toUpperCase());
        }
        for(int i=0; i<str2.length()-1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i+1);
            if(!Character.isAlphabetic(c1) || !Character.isAlphabetic(c2)) continue;
            str2_list.add(String.valueOf(c1 +""+ c2).toUpperCase());       
        }
        
        List<String> cha = new ArrayList<>(str1_list);
        for(String s : str2_list) cha.remove(s); // 차집합 구하기
        
        int hab_size = str2_list.size() + cha.size();
        int gyo_size = str1_list.size() - cha.size();
        if(hab_size == 0) answer = 65536;
        else answer = (int)(gyo_size / (double)hab_size * 65536);   
        
        return answer;
    }
}