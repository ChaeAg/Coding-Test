import java.util.*;
class Solution {
    public int minSteps(String s, String t) {
        int[] cnt = new int[125];
        for(char c : s.toCharArray()) {
            cnt[c]++;
        }

        int answer = 0;
        for(char c : t.toCharArray()) {
            if(cnt[c] == 0) answer++;
            else cnt[c]--;
        }

        return answer;
    }
}