import java.util.*;
class Solution {
    public int solution(String s) {
        List<String> list = List.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        String result = "";
        String word = "";
        for(String str : s.split("")) {
            if(str.matches("[-+]?\\d*\\.?\\d+")) {
                result += Integer.parseInt(str);
            }
            else {
               word += str;
            }
            if(list.contains(word)) {
                 result += list.indexOf(word);
                 word = "";
            }
        }
        return Integer.parseInt(result);
    }
}