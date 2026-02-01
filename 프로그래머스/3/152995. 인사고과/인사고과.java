import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        PriorityQueue<int[]> tempQue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];  // 두 번째 점수 오름차순
            }
            return o2[0] - o1[0];  // 첫 번째 점수 내림차순
        });
        
        for (int i = 0; i < scores.length; i++) {
            tempQue.add(new int[]{scores[i][0], scores[i][1], i});
        }
        
        PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        
        int max = 0;
        while (!tempQue.isEmpty()) {
            int[] nowScore = tempQue.poll();
            
            if (nowScore[1] < max) {
                if (nowScore[2] == 0) { // 완호 탈락
                    return -1;
                }
                continue;
            }
            
            max = Math.max(max, nowScore[1]);
            que.add(new int[]{nowScore[2], nowScore[0] + nowScore[1]});
        }
        
        int rank = 0, gague = 1, beforeScore = -1;
        boolean isFind = false;
        while (!que.isEmpty()) {
            int[] score = que.poll();
            if (beforeScore == score[1]) {
                gague++;
            } else {
                rank += gague;
                gague = 1;
                beforeScore = score[1];
            }
            if (score[0] == 0) {
                isFind = true;
                break;
            }
        }
        return isFind ? rank : -1;
    }
}