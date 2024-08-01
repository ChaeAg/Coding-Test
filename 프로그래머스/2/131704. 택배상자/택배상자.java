import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int[] main = new int[order.length];
        
        for(int i = 0; i < order.length; i++) {
            main[order[i] - 1] = i; // 우선 순위 넣음
        }
        
        Stack<Integer> assistant = new Stack<>();
     
        for(int i = 0; i < main.length; i++) {
            if(main[i] == answer) {
                answer++;
            }
            else {
                assistant.push(main[i]); // 자기 차례 아니면 보조 컨테이너로 감
            }
            
            while(!assistant.isEmpty() && assistant.peek() == answer){
                assistant.pop();
                answer++;
            }
        }
        
        return answer;
    }
}