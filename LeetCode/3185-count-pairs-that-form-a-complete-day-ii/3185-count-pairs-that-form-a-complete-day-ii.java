import java.util.*;
class Solution {
    public long countCompleteDayPairs(int[] hours) {
        Map<Integer, Integer> map = new HashMap<>();
        long cnt = 0;
        for(int hour : hours) {
            int newHour = hour % 24;
            Integer i = map.get(newHour == 0 ? 0 : 24 - newHour);
            if(i != null) {
                cnt += i;
            }
            map.put(newHour, map.getOrDefault(newHour, 0)+1);
        }
        return cnt;
    }
}