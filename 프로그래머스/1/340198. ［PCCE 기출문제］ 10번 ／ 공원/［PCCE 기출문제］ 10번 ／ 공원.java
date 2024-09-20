import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        Arrays.sort(mats);

        for(int i=0; i<park.length; i++) {
            for(int j=0; j<park[0].length; j++) {
                for(int k=0; k<mats.length; k++) {
                    boolean isOk = true;
                    for(int k1=0; k1<mats[k]; k1++) {
                        for(int k2=0; k2<mats[k]; k2++) {
                            if(i+k1 >= park.length || j+k2 >= park[0].length || !park[i+k1][j+k2].equals("-1")) {
                                isOk = false;
                                break;
                            }
                        }
                        if(!isOk) break;
                    }
                    if(!isOk) break;

                    answer = answer > mats[k] ? answer : mats[k]; // 이 돗자리 성공
                }
            }
        }

        return answer;
    }
}