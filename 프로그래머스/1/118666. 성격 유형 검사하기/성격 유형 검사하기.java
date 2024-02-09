import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String, Integer> result = new HashMap<>(){{
            put("R", 0);
            put("T", 0);
            put("C", 0);
            put("F", 0);
            put("J", 0);
            put("M", 0);
            put("A", 0);
            put("N", 0);
        }};

        for(int i=0; i<survey.length; i++) {
            int selectNum = choices[i];
            if(selectNum < 4) { // XY 중 X형 점수 업
                String type = survey[i].substring(0, 1);
                result.put(type, result.get(type) + 4 - selectNum);
            }
            else { // XY 중 Y형 점수 업
                String type = survey[i].substring(1);
                result.put(type, result.get(type) + selectNum - 4);
            }
        }

        answer += result.get("R") < result.get("T") ? "T" : "R";
        answer += result.get("C") < result.get("F") ? "F" : "C";
        answer += result.get("J") < result.get("M") ? "M" : "J";
        answer += result.get("A") < result.get("N") ? "N" : "A";

        return answer;
    }
}