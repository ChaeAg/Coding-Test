import java.util.*;
class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        Arrays.fill(answer, "");
        int idx = 0;
        for(int i=0; i<picture.length; i++) {
            for(int a=0; a<k; a++) {
                for(int b=0; b<picture[i].length(); b++) {
                    char c = picture[i].charAt(b);
                    for(int j=0; j<k; j++) {
                        answer[idx] += c;
                    }
                }
                idx++;
            }
        }
        
        return answer;
    }
}