import java.util.*;
class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int len = rectangle.length;
        // 선인 부분은 1, 빈 부분 0, 침범할 수 없는 구역이면(사각형 내부면) -1
        int[][] map = new int[101][101]; // 맵의 크기가 50x50이 최대기 때문에 2배+1 // 0은 사용x 1부터 사용
        
        for(int i=0; i<rectangle.length; i++) {
            int[] rect = rectangle[i];
            int sx = rect[0]; int sy = rect[1]; int ex = rect[2]; int ey = rect[3];
            
            // map 정보 채워주기
            for(int x=sx*2; x<=ex*2; x++) {
                for(int y=sy*2; y<=ey*2; y++) {
                    if(map[y][x] == -1) continue;
                    
                    if(x == sx*2 || x == ex*2 || y == sy*2 || y == ey*2) {
                        map[y][x] = 1;    
                    }
                    else {
                        map[y][x] = -1;   
                    }
                }
            }
        }
        
        return bfs(map, characterX*2, characterY*2, itemX*2, itemY*2) / 2; // 2배 거리이기 때문에 나누기 2 해줌
    }
    
    int bfs(int[][] map, int cx, int cy, int itemX, int itemY) {
        int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
        
        boolean[][] visited = new boolean[101][101];
        
        Queue<int[]> q = new LinkedList();
        
        q.add(new int[]{cy, cx});
        visited[cy][cx] = true;
        map[cy][cx] = 0;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1];
            
            for(int[] m : move) {
                int nx = x + m[1];
                int ny = y + m[0];
                
                if(nx <= 0 || nx > 100 || ny <= 0 || ny > 100) continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx] != 1) continue;
                
                visited[ny][nx] = true;
                q.add(new int[]{ny, nx});
                map[ny][nx] = map[y][x] + 1; 
            }
        }
        
        return map[itemY][itemX];
    }
}