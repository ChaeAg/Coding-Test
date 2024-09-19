import java.util.*;
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int[] now = Arrays.stream(pos.split(":")).mapToInt(Integer::parseInt).toArray();
        int[] end = Arrays.stream(video_len.split(":")).mapToInt(Integer::parseInt).toArray();
        int[] op = new int[4];
        String[] op_s = op_start.split(":");
        String[] op_e = op_end.split(":");
        
        for(int i=0; i<4; i++) {
            if(i < 2) {
                op[i] = Integer.parseInt(op_s[i]);
            }
            else {
                op[i] = Integer.parseInt(op_e[i-2]);
            }
        }
        
        
        for(String command : commands) {
            if((now[0] > op[0] || (now[0] == op[0] && now[1] >= op[1])) && (now[0] < op[2] || (now[0] == op[2] && now[1] < op[3]))) { // 오프닝 구간
            now[0] = op[2];
            now[1] = op[3];
        }
            
            if(command.equals("next")) {
                now[1] += 10;
                if(now[1] >= 60) {
                    now[0]++;
                    now[1] -= 60;
                }
                
                if(now[0] >= end[0] && now[1] > end[1]) {
                    now[0] = end[0];
                    now[1] = end[1];
                }
            }
            else {
                now[1] -= 10;
                if(now[1] < 0) {
                    now[0]--;
                    now[1] += 60;
                }
                
                if(now[0] < 0) {
                    now[0] = 0;
                    now[1] = 0;
                }
            }
            
            System.out.println(now[0] + ":" + now[1]);
        }
        
        if((now[0] > op[0] || (now[0] == op[0] && now[1] >= op[1])) && (now[0] < op[2] || (now[0] == op[2] && now[1] < op[3]))) { // 오프닝 구간
            now[0] = op[2];
            now[1] = op[3];
        }
        
        return String.format("%02d:%02d", now[0], now[1]);
    }
}