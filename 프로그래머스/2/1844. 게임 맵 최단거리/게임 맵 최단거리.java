import java.util.*;
class Solution {
    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 순서대로 동,서,남,북
    public int solution(int[][] maps) {
        int[][] visited = new int[maps.length][maps[0].length];
        bfs(maps, visited);
        int answer = visited[maps.length-1][maps[0].length-1];
        return answer == 0 ? -1 : answer;
    }
    
    static void bfs(int[][] maps, int[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = 1;
        
        while(!queue.isEmpty()) {
            int[] temp = queue.remove();
            int y = temp[0];
            int x = temp[1];
            
            for(int i=0; i<4; i++) {
                int f_y = y + move[i][0];
                int f_x = x + move[i][1];
                if(f_y < 0 || f_y > maps.length-1 || f_x < 0 || f_x > maps[0].length-1) continue;
                if(visited[f_y][f_x] == 0 && maps[f_y][f_x] == 1) {
                    queue.add(new int[]{f_y, f_x});
                    visited[f_y][f_x] = visited[y][x] + 1;
                }
            }
        }
    }
}