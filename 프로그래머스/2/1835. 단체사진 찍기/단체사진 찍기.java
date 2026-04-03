import java.util.*;
class Solution {
    String[] members = {"A", "C", "F", "J", "M", "N", "R", "T"};
    String[][] data;
    int answer = 0;
    public int solution(int n, String[] data) {
        this.data = new String[n][5];
        for(int i=0; i<n; i++) {
            this.data[i] = data[i].split("");
        }
        func(0, new ArrayList<>(8));
        return answer;
    }
    
    void func(int depth, List<String> list) {
        if(depth == 8) {
            boolean valid = true;
            for(String[] strs : data) {
                int idx_dist = Math.abs(list.indexOf(strs[0])-list.indexOf(strs[2])) - 1;
                int num = Integer.parseInt(strs[4]);
                
                valid = switch (strs[3]) {
                    case "=" -> idx_dist == num;
                    case ">" -> idx_dist > num;
                    case "<" -> idx_dist < num;
                    default -> false;
                };

                if (!valid) {
                    return;
                }
            }
            
            answer++;
            return;
        }
        
        for(int i=0; i<8; i++) {
            if(!list.contains(members[i])) {
                list.add(members[i]);
                func(depth+1, list);
                list.remove(list.size()-1);
            }
        }
    }
}