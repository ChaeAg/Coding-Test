import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        
        for(int tan : tangerine) { // 귤의 개수 같은 크기별로 묶어서 세기
            counts.put(tan, counts.getOrDefault(tan, 0) + 1);
        }
        
        // 맵 내림차순 정렬
        List<Integer> keys = new ArrayList<>(counts.keySet());
        keys.sort((o1, o2) -> counts.get(o2).compareTo(counts.get(o1)));
        
        int box = 0;
        for(int key : keys) { // 제일 많은 크기인 귤부터 다 넣어보고 모자른지 만족했는지 판단하는 과정 반복
            box += counts.get(key);
            answer++;
            if(box >= k) break;
        }
        
        return answer;
    }
}