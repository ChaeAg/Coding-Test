import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int[] checkX = new int[10];
        int[] checkY = new int[10];
        List<String> result = new ArrayList();
        
        for(String w : X.split("")) {
            checkX[Integer.parseInt(w)]++;
        }
        for(String w : Y.split("")) {
            checkY[Integer.parseInt(w)]++;  
        }
        
        for(int i=0; i<10; i++) {
            if(checkX[i] != 0 && checkY[i] != 0) {
                int min = Math.min(checkX[i], checkY[i]);
                for(int j=0; j<min; j++) {
                    result.add(String.valueOf(i));
                }
            }
        }
        
        if(result.size() == 0) answer = "-1";
        else {
            // 짝꿍이 0으로만 구성되어 있는지 확인
            boolean b = true;
            for(String s : result) {
                if(!s.equals("0")) {
                    b = false;
                    break;
                }
            }
            if(b) {
                answer = "0";
            }
            else {
                result.sort(Comparator.reverseOrder());
                answer = String.join("", result);
            }
        }
        
        return answer;
    }
}