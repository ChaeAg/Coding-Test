import java.util.*;
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int len = words.length;
        String[] backupWords = Arrays.copyOf(words, len);
        List<String> orderList = List.of(order.split(""));

        String[][] wordsArr = new String[len][20];
        for (int i = 0; i < len; i++) {
            wordsArr[i] = words[i].split("");
        }

        Arrays.sort(wordsArr, (o1, o2) -> {
            int minLen = Math.min(o1.length, o2.length);
            for (int i = 0; i < minLen; i++) {
                if (!o1[i].equals(o2[i])) {
                    return orderList.indexOf(o1[i]) - orderList.indexOf(o2[i]);
                }
            }
            return o1.length - o2.length;
        });

        for (int i = 0; i < len; i++) {
            if (!backupWords[i].equals(String.join("", wordsArr[i]))) {
                return false;
            }
        }

        return true;
    }
}