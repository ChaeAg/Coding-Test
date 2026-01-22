import java.util.*;

class Solution {
    int mapSize, len;
    String[][] maps;
    public int solution(String[] maps) {
        mapSize = maps.length;
        len = maps[0].length();
        this.maps = new String[mapSize][len];

        int[] start = new int[2];
        int[] lever = new int[2];
        int[] door = new int[2];
        
        for(int i=0; i<mapSize; i++) {
            String[] strs = maps[i].split("");
            for(int j=0; j<len; j++) {
                this.maps[i][j] = strs[j];
                
                switch(strs[j]) {
                    case "S":
                        start[0] = i;
                        start[1] = j; 
                        break;
                    case "E":
                        door[0] = i;
                        door[1] = j;
                        break;
                    case "L":
                        lever[0] = i;
                        lever[1] = j;
                }
            }
        }
        
        int firstAnswer = bfs(start, lever);
        if(firstAnswer == -1) return -1;
        
        int secondAnswer = bfs(lever, door);
        if(secondAnswer == -1) return -1;
        
        return firstAnswer + secondAnswer;
    }
    
    int bfs(int[] start, int[] end) {
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        Queue<int[]> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[mapSize][len];
        
        que.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while(!que.isEmpty()) {
            int[] now = que.poll();
            
            for(int[] move : moves) {
                int nextX = now[0] + move[0];
                int nextY = now[1] + move[1];
                
                if(nextX < 0 || nextX >= mapSize || nextY < 0 || nextY >= len || visited[nextX][nextY] || maps[nextX][nextY].equals("X")) 
                    continue;
                
                if(nextX == end[0] && nextY == end[1]) 
                    return now[2] + 1;
                
                que.add(new int[]{nextX, nextY, now[2]+1});
                visited[nextX][nextY] = true;
            }
        }
        
        return -1;
    }
}