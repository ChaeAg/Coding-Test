import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new ArrayDeque<>(); // 대기 트럭 큐
        Queue<Integer> ing = new ArrayDeque<>(); // 다리 위 트럭 큐
        Queue<Integer> out_time = new ArrayDeque<>(); // 다리 위 트럭들의 도착 시간 큐
        
        for(int tw : truck_weights) { // 대기 트럭 세팅
            q.offer(tw);
        }
        
        int time = 0; // 경과 시간
        int ing_weight = 0; // 다리 건너고 있는 트럭들의 무게 합
        
        while(!(q.isEmpty() && ing.isEmpty())) {
            if(!out_time.isEmpty() && out_time.peek() == time) { // 건너고 있던 트럭 중 맨 앞 트럭이 건너편에 도착했을 경우
                out_time.poll();                
                ing_weight -= ing.poll();
            }
            if(!q.isEmpty() && ing_weight + q.peek() <= weight) { // 대기 중 트럭이 있으면서 그 트럭이 다리에 올라갈 수 있는 경우
                int truck_weight = q.poll();
                ing.offer(truck_weight);
                ing_weight += truck_weight;
                out_time.offer(time + bridge_length); // 지금 올라간 트럭이 건너편에 도착하는 시간
            }
            time++;
        }
        
        return time;
    }
}