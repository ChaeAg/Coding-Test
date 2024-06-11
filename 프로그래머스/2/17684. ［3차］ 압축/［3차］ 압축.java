import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        List<String> library = new ArrayList<>();

        for (char c = 'A'; c <= 'Z'; c++) { // 기본 사전 세팅
            library.add(String.valueOf(c));
        }

        int len = msg.length();

        for (int i = 0; i < len; i++) {
            int end = len; 
            while (!library.contains(msg.substring(i, end))) {
                end--;
            } // 일치하는 문자열(w)을 찾았을 경우 빠져나옴
            answer.add(library.indexOf(msg.substring(i, end)) + 1); // 색인 번호 기록

            if (end == len) break; // 마지막 문자까지 처리 했을 경우

            library.add(msg.substring(i, end + 1)); // w+c 단어 사전에 등록
            i = end - 1;
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}