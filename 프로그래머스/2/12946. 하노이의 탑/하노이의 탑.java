import java.util.*;
class Solution {
    List<int[]> answerList = new ArrayList<>();
    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
        
        int answerSize = answerList.size();
        int[][] answer = new int[answerSize][2];
        
        for(int i = 0; i<answerSize; i++) {
            answer[i] = answerList.get(i);
        }
            
        return answer;
    }
    
    void move(int start, int end) {
        answerList.add(new int[]{start, end});
    }
    
    void hanoi(int N, int start, int to, int via) {
        if(N == 1) {
            move(start, to);
            return;
        }
            
        hanoi(N-1, start, via, to);
        
        move(start, to);
        
        hanoi(N-1, via, to, start);
    }
}