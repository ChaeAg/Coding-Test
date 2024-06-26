import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int num = 0;
        int count = 0;
        List<String> list = new ArrayList<>();
        int idx = 0;
        int next = p - 1;
        
        while(count < t) {
            for(String str : Integer.toString(num, n).split("")) {
                list.add(str);
            }
            
            while(list.size() > next && count < t) {
                answer += list.get(next);
                count++;
                next += m;
            }
            
            num++;
        }
        
        return answer.toUpperCase();
    }
}