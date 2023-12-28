import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> jundang = new ArrayList(); // 명예의 전당에 오른 점수 리스트
        
        for(int i=0; i<answer.length; i++) {
            jundang.add(score[i]); // 일단 명예의 전당에 넣어줌
            if(jundang.size() > k) { // 명예의 전당에 오른 점수 개수가 k개를 초과했을 때
                int min = jundang.stream() // 명예의 전당에서 최솟값 구함
                    .mapToInt(Integer::intValue)
                    .min()
                    .getAsInt();
                jundang.remove(jundang.indexOf(min)); // 명예의 전당에서 최솟값 제거
            }
            answer[i] = jundang.stream()
                .mapToInt(Integer::intValue)
                .min()
                .getAsInt();
        }
        
        return answer;
    }
}