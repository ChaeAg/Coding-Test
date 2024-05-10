import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length * 5;
        
        int answer = 0;
        List<String> LRU = new ArrayList<>();
            
        for(String city : cities) {
            String l_city = city.toLowerCase();
            if(LRU.contains(l_city)) {
                LRU.remove(l_city);
                answer += 1;
            }
            else {
                answer += 5;
            }
            
            if(LRU.size() != 0 && LRU.size() >= cacheSize) {
                LRU.remove(0);
            }
            
            LRU.add(l_city);
        }
        
        return answer;
    }
}