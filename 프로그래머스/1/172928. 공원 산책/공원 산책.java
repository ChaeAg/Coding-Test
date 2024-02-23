class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[] dog = new int[2];
        int h = park.length; // 공원 세로 길이
        int w = park[0].length(); // 공원 가로 길이
        
        // 강아지 시작 위치 찾기
        for(int i=0; i<park.length; i++) {
            if(park[i].contains("S")) {
                dog[0] = i;
                dog[1] = park[i].indexOf("S");
                break;
            }
        }
        
        for(String route : routes) {
            String[] strs = route.split(" ");
            int idx = 0;
            switch(strs[0]) {
                case "N":
                    idx = 0;
                    break;
                case "S":
                    idx = 1;
                    break;
                case "W":
                    idx = 2;
                    break;
                case "E":
                    idx = 3;
                    break;
            }
            int[] movedog = new int[]{dog[0], dog[1]};
            boolean complate = true;
            
            for(int i=0; i<Integer.parseInt(strs[1]); i++) {
                movedog[0] += move[idx][0];
                movedog[1] += move[idx][1];
                
                if(movedog[0] >= 0 && movedog[0] < h) {
                    if(movedog[1] >= 0 && movedog[1] < w) {
                        if(park[movedog[0]].charAt(movedog[1]) != 'X') {
                            // 한 칸 전진했을 때 문제 없으면 여기로 옴
                            continue;
                        }
                    }
                }
                // 해당 명령 수행 불가하면 여기로 옴
                complate = false; 
                break;
            }
            
            if(complate) dog = movedog;            
        }
        
        return dog;
    }
}