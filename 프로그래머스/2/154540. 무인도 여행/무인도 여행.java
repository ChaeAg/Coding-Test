import java.util.*;
class Solution {
    int mapSize, len;
    String[][] maps;
    boolean[][] visited;
    int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        
        mapSize = maps.length;
        len = maps[0].length();
        this.maps = new String[mapSize][len];
        for(int i=0; i<mapSize; i++) {
            this.maps[i] = maps[i].split("");
        }
        
        visited = new boolean[mapSize][len];
        
        for(int i=0; i<mapSize; i++) {
            for(int j=0; j<len; j++) {
                if(!this.maps[i][j].equals("X") && !visited[i][j]) {
                    answer.add(bfs(i, j));
                }
            }
        }
        
        if(answer.isEmpty()) {
            return new int[]{-1};
        }
        
        return answer.stream().mapToInt(i -> i).sorted().toArray();
    }
    
    int bfs(int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        visited[x][y] = true;
        int cost = Integer.parseInt(maps[x][y]);
        
        while(!que.isEmpty()) {
            int[] now = que.poll();
            
            for(int[] move : moves) {
                int nextX = now[0] + move[0];
                int nextY = now[1] + move[1];
                
                if(nextX < 0 || nextX >= mapSize || nextY < 0 || nextY >= len
                  || "X".equals(maps[nextX][nextY]) || visited[nextX][nextY]) continue;
                
                cost += Integer.parseInt(maps[nextX][nextY]);
                visited[nextX][nextY] = true;
                que.add(new int[]{nextX, nextY});
            }
        }
        
        return cost;
    }
}