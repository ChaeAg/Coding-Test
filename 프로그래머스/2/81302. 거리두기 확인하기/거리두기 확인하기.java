class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        int[][] default_move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] special_move = {{-1, -1, -1, 1}, {1, -1, 1, 1}, {-1, -1, 1, -1}, {-1, 1, 1, 1}};
        // 상 하 좌 우 순서
        
        for(int i=0; i<5; i++) { // 총 대기실 5개
            boolean isOk = true;
            String[][] place = new String[5][5];
            for(int q=0; q<5; q++) {
                place[q] = places[i][q].split("");
            }
            
            for(int j=0; j<5 && isOk; j++) {
                for(int k=0; k<5 && isOk; k++) {
                    if(!place[j][k].equals("P")) continue; // 사람이 앉은자리가 아니라면 패스
                    
                    for(int c=0; c<4; c++) { // 상 하 좌 우 확인
                        int next_j = j + default_move[c][0];
                        int next_k = k + default_move[c][1];
                        if(next_j >= 0 && next_j < 5 && next_k >= 0 && next_k < 5){
                            if(place[next_j][next_k].equals("P")) {
                                isOk = false;
                                break;
                            }
                            if(place[next_j][next_k].equals("O")) {
                                next_j = next_j + default_move[c][0];
                                next_k = next_k + default_move[c][1];
                                if(next_j >= 0 && next_j < 5 && next_k >= 0 && next_k < 5
                                   && place[next_j][next_k].equals("P")) {
                                    isOk = false;
                                    break;        
                                }
                                
                                next_j = j + special_move[c][0];
                                next_k = k + special_move[c][1];
                                if(next_j >= 0 && next_j < 5 && next_k >= 0 && next_k < 5
                                   && place[next_j][next_k].equals("P")) {
                                    isOk = false;
                                    break;        
                                }
                                
                                next_j = j + special_move[c][2];
                                next_k = k + special_move[c][3];
                                if(next_j >= 0 && next_j < 5 && next_k >= 0 && next_k < 5
                                   && place[next_j][next_k].equals("P")) {
                                    isOk = false;
                                    break;        
                                }
                            }
                        }
                    }
                }
            }
            
            if(isOk) answer[i] = 1;
        }
        
        return answer;
    }
}