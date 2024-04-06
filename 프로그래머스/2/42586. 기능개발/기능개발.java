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

            day = (int) Math.ceil((100 - prog) / (double)speeds[idx]); // 이 기능을 개발하는데 걸리는 기간

            if(before_day >= day) { // 이미 개발 되어 있는 기능일 경우
                map.replace(before_day, map.get(before_day) + 1);
            }
            else { // 기간을 더 들여서 개발해야 할 경우
                map.put(day, 1);
            }

            idx++;
            before_day = before_day < day ? day : before_day;
        }

        int[] answer = new int[map.size()];
        int i = 0;
        for(int cnt : map.values()) {
            answer[i++] = cnt;
        }
        
        return answer;
    }
}