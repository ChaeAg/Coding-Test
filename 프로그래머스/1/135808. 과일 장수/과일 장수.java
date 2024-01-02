import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        score = Arrays.stream(score)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
        
        for(int i=0; i<score.length-(score.length % m); i++) {
            if(i % m == (m-1)) {
                answer += score[i] * m;
            }
        }
        
        return answer;
    }
}