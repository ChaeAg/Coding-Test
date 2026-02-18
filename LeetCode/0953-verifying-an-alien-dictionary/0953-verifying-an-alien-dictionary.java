import java.util.*;
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int len = words.length;
        String[] backupWords = Arrays.copyOf(words, len);
        Map<Character, Integer> orderMap = new HashMap<>();
        int rank = 1;
        for(char o : order.toCharArray()) {
            orderMap.put(o, rank++);
        }

        Arrays.sort(words, (o1, o2) -> {
            int minLen = Math.min(o1.length(), o2.length());
            for (int i = 0; i < minLen; i++) {
                char c1 = o1.charAt(i);
                char c2 = o2.charAt(i);
                if (c1 != c2) {
                    return orderMap.get(c1) - orderMap.get(c2);
                }
            }
            return o1.length() - o2.length();
        });

        for (int i = 0; i < len; i++) {
            if (!backupWords[i].equals(words[i])) {
                return false;
            }
        }

        return true;
    }
}