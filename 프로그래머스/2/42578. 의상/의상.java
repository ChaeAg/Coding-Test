import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> counts = new HashMap<>();
        
        for(String[] cloth : clothes) {
            counts.put(cloth[1], counts.getOrDefault(cloth[1], 0) + 1);
        }
		
        for(String key : counts.keySet()) {
            answer *= counts.get(key) + 1; // 안입는 경우까지 고려해서 +1 해서 곱함
        }
        
        // 아무것도 안 입는 경우 빼줌
        answer -= 1;
        
        return answer;
    }
}