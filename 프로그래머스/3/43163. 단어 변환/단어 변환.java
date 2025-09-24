// class Solution {
//     String target;
//     String[] words;
//     int answer = 0;
//     int word_len;
//     static boolean[] visited;
//     public int solution(String begin, String target, String[] words) {
//         this.target = target;
//         this.words = words;
//         word_len = words[0].length();
//         visited = new boolean[words.length];

//         dfs(0, begin);
        
//         return answer;
//     }
    
//     public void dfs(int count, String begin) {
//         if(begin.equals(target)) { // 단어가 target과 같아졌을 경우
//             if(answer == 0) answer = count;
//             else answer = answer > count ? count : answer;
//             return;
//         }

//         for(int i=0; i<words.length; i++) { // words 전체를 돈다.
//             if(words[i].equals(begin) || visited[i]) continue; // 같은 단어거나, 이미 방문했던 단어면 패스

//             // 문자열 자리마다 비교하기 위해 char배열로 변환
//             char[] c_begin = begin.toCharArray();
//             char[] c_word = words[i].toCharArray();
//             int different_count = 0; // 두 문자열의 다른 자리 수 세는 용도

//             for(int j=0; j<word_len; j++) { // 두 문자열 비교 시작 
//                 if(c_begin[j] != c_word[j]) different_count++;

//                 if(different_count > 1) break;
//             }

//             if(different_count == 1) {
//                 visited[i] = true;
//                 dfs(count + 1, words[i]);
//                 visited[i] = false;
//             }
//         }
//     }
// }

import java.util.Arrays;
import java.util.stream.Collectors;
class Solution {
    static String[] arr;
    static String t;
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        t = target;
        arr = words;

        if (Arrays.stream(words).collect(Collectors.toList()).contains(target)) {
            answer = words.length;
            dfs(0, begin, words);
        }
        
        return answer;
    }
    
    static void dfs(int dept, String now_word, String[] now_arr) {
        if (now_word.equals(t) || dept > answer) {
            answer = Math.min(answer, dept);
            return;
        }

        for (int i = 0; i < now_arr.length; i++) {
            int not_same_count = 0;
            for (int j = 0; j < now_word.length(); j++) {
                if (now_arr[i].isEmpty()) {
                    continue;
                }
                if (now_word.charAt(j) != now_arr[i].charAt(j)) {
                    if (++not_same_count > 1) {
                        break;
                    }
                }
            }

            if (not_same_count == 1) {
                now_word = now_arr[i];
                now_arr[i] = "";
                dfs(dept + 1, now_word, now_arr);
            }
        }
    }
}