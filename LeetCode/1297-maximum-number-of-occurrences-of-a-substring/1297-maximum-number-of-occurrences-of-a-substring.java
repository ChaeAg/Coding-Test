import java.util.*;
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int subStrLen = maxSize+1;
        Map<String, Integer> subStrCnt = new HashMap<>();
        int maxCnt = 0;

        while(--subStrLen >= minSize) {
            for(int i=0; i<=s.length()-subStrLen; i++) {
                String str = s.substring(i, i + subStrLen);

                if(subStrCnt.containsKey(str)) {
                    int cnt = subStrCnt.get(str) + 1;
                    subStrCnt.put(str, cnt);
                    maxCnt = Math.max(maxCnt, cnt);
                    continue;
                } 

                Set<Character> set = new HashSet<>();
                for(char c : str.toCharArray()) {
                    set.add(c);
                    if(set.size() > maxLetters) {
                        break;
                    }
                }

                if(set.size() <= maxLetters) {
                    subStrCnt.put(str, 1);
                    maxCnt = Math.max(maxCnt, 1);
                }
            }
        }
        
        return maxCnt;
    }
}