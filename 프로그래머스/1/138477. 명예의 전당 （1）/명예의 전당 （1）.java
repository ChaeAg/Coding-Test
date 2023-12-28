import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        // PriorityQueue: 우선순위를 지정할 수 있는 큐
        // 낮은 숫자가 우선 순위인 큐
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // 높은 숫자가 우선 순위인 큐 -> PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<answer.length; i++) {
            queue.add(score[i]);
            if(queue.size() > k) queue.poll(); // poll(): 첫번째 값을 반환하고 제거, 비어있다면 null 리턴
            answer[i] = queue.peek(); // peek(): 첫번째 값을 반환
        }
        
        return answer;
        
//         int[] answer = new int[score.length];
//         List<Integer> jundang = new ArrayList(); // 명예의 전당에 오른 점수 리스트
        
//         for(int i=0; i<answer.length; i++) {
//             jundang.add(score[i]); // 일단 명예의 전당에 넣어줌
//             if(jundang.size() > k) { // 명예의 전당에 오른 점수 개수가 k개를 초과했을 때
//                 int min = jundang.stream() // 명예의 전당에서 최솟값 구함
//                     .mapToInt(Integer::intValue)
//                     .min()
//                     .getAsInt();
//                 jundang.remove(jundang.indexOf(min)); // 명예의 전당에서 최솟값 제거
//             }
//             answer[i] = jundang.stream()
//                 .mapToInt(Integer::intValue)
//                 .min()
//                 .getAsInt();
//         }
        
//         return answer;
    }
}