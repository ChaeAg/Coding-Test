import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for(int i=0; i<A.length; i++) {
            que.add(A[i]);
        }
        
        Arrays.sort(B);
        int b_idx = 0;
        while(!que.isEmpty() && b_idx < B.length) {
            int num = que.poll();
            if(num < B[b_idx]) {
                answer++;
            } else {
                que.add(num);
            }
            b_idx++;
        }
        
        return answer;
    }
}