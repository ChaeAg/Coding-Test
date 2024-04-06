import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new ArrayDeque<>();
        int day = 0;
        int before_day = 0;
        int idx = 0;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        
        for(int progress : progresses) { // 큐 세팅
            q.offer(progress);
        }
        
        while(!q.isEmpty()) {
            int prog = q.poll(); // 먼저 개발해야 하는 기능 순으로 나옴
            
            while(prog + (speeds[idx] * day) < 100) {
                day++;
            }
            
            if(before_day == day) { // 위 while을 거치지 않고 이미 개발 된 기능일 경우
                map.replace(day, map.get(day) + 1);
            }
            else {
                map.put(day, 1);
            }
            
            idx++;
            before_day = day;
        }
        
        int[] answer = new int[map.size()];
        int i = 0; 
        for(int cnt : map.values()) {
            answer[i++] = cnt;
        }
        
        return answer;
    }
}