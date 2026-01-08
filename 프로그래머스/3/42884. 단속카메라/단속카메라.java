import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        int end = -30001;
        for(int i=0; i<routes.length; i++) {
            if(routes[i][0] > end) {
                answer++;
                end = routes[i][1];
            }
        }
    
        return answer;
    }
}