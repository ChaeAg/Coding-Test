class Solution {
    public int solution(String dirs) {
        int answer = 0;
        String[][] temp = new String[11][11];
        int x = 5, y = 5;
        
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                temp[i][j] = "";
            }
        }
        
        for(String s : dirs.split("")) {
            if(s.equals("U")) {
                if(y + 1 > 10) continue;
                y++;
                if(temp[y][x].contains("U")) continue;
                temp[y][x] += temp[y][x] + "U";
                temp[y-1][x] += temp[y-1][x] + "D";
                answer++;
            }
            else if(s.equals("D")) {
                if(y - 1 < 0) continue;
                y--;
                if(temp[y][x].contains("D")) continue;
                temp[y][x] += temp[y][x] + "D";
                temp[y+1][x] += temp[y+1][x] + "U";
                answer++;
            }
            else if(s.equals("L")) {
                if(x - 1 < 0) continue;
                x--;
                if(temp[y][x].contains("L")) continue;
                temp[y][x] += temp[y][x] + "L";
                temp[y][x+1] += temp[y][x+1] + "R";
                answer++;
            }
            else {
                if(x + 1 > 10) continue;
                x++;
                if(temp[y][x].contains("R")) continue;
                temp[y][x] += temp[y][x] + "R";
                temp[y][x-1] += temp[y][x-1] + "L";
                answer++;
            }
        }
        
        return answer;
    }
}