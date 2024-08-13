import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        return y == x ? 0 : bfs(x, y, n);
    }
    
    public int bfs(int x, int y, int n) {
        int[] move = {n, 2, 3};
        int[] count = new int[y+1];
        Queue<Integer> que = new LinkedList<>();
        que.add(y);
        count[y] = 0;
        
        while(!que.isEmpty()) {
            int num = que.poll();
            
            for(int i=0; i<3; i++) {
                int next_num = num;
                if(i == 0) {
                    next_num -= move[i];
                }
                else if(next_num % move[i] == 0) {
                    next_num /= move[i];
                }
                else continue;
                
                if(next_num < x || count[next_num] != 0) continue;
                count[next_num] = count[num] + 1;
                que.add(next_num);
            }
        }
        
        return count[x] == 0 ? -1 : count[x];
    }
}