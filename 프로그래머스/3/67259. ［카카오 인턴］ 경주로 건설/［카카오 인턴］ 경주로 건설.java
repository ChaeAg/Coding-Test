import java.util.*;
class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int[] move = {1, -1};
        
        Queue<int[]> que = new LinkedList<>();
        int[][][] cost = new int[2][n][n]; // 3차원인 이유: 가로 방향, 세로 방향 비용을 다 저장하기 위함.
        
        int max_money = n * n * 5000;
        for(int i=0; i<2; i++) {
            for(int j=0; j<n; j++) {
                Arrays.fill(cost[i][j], max_money);
            }
        }
        
        // 처음 가로 세로만 한번씩 초기화
        if(board[0][1] == 0) {
            cost[0][0][1] = 100;
            que.add(new int[]{0, 1, 0});
        }
        if(board[1][0] == 0) {
            cost[1][1][0] = 100;
            que.add(new int[]{1, 0, 1});
        }
        
        while(!que.isEmpty()) {
            int[] now = que.poll();
            int x = now[0];
            int y = now[1];
            int allow = now[2];
            
            /* 
            오른쪽 또는 왼쪽으로 한 칸 이동
            */
            for(int m : move) {
                int next_y = y + m;
                int next_cost;
                
                if(next_y < n && next_y >= 0 && board[x][next_y] == 0) {
                    if(allow == 0) { // 원래 오른쪽으로 가고 있었다. (기존 방향과 새로운 방향 일치)
                        next_cost = cost[0][x][y] + 100;
                    }
                    else { // 원래 아래로가고 있는 중이었다면? -> 코너 생성!
                        next_cost = cost[1][x][y] + 100 + 500;
                    }         
                    
                    if(next_cost < cost[0][x][next_y]) {
                        cost[0][x][next_y] = next_cost;
                        que.add(new int[]{x, next_y, 0});   
                    }
                }
            }
            
            /*
            아래쪽 또는 위쪽으로 한 칸 이동
            */
            for(int m : move) {
                int next_x = x + m;
                int next_cost;

                if(next_x >= n || next_x < 0 || board[next_x][y] == 1) continue;

                if(allow == 0) { // 원래 오른쪽으로 가고 있는 중이었다면? -> 코너 생성!
                    next_cost = cost[0][x][y] + 100 + 500;
                }
                else { // 원래 아래쪽으로 가고 있었다.(기존 방향과 새로운 방향 일치)
                    next_cost = cost[1][x][y] + 100;
                }                       

                if(next_cost < cost[1][next_x][y]) {
                    cost[1][next_x][y] = next_cost;
                    que.add(new int[]{next_x, y, 1});
                }
            }
        }
        
        return Math.min(cost[0][n-1][n-1], cost[1][n-1][n-1]);
    }
}