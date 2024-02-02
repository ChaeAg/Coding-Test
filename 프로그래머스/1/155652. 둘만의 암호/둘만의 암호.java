import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        char[] sWord = s.toCharArray();
        List<String> skipWord = Arrays.stream(skip.split(""))
            .collect(Collectors.toList());
        
        for(char word : sWord) {
            int count = 0;
            while(count < index) {
                count++;
                word++;
                if(word > 'z') { // z를 넘어간 경우
                    word = 'a';
                }
                if(skipWord.contains(String.valueOf(word))) { // skip에 있는 알파벳인 경우
                    count--;
                }
            }
            answer += word;
        }
        
        return answer;
    }
}