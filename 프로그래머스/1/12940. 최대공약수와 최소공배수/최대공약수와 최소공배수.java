import java.util.*;
class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        List<Integer> yaksu_n = new ArrayList();
        List<Integer> yaksu_m = new ArrayList();
        int max_yaksu = 1;
        for(int i=2; i<=n; i++) {
            if(n % i == 0) yaksu_n.add(i);
        }
        for(int i=2; i<=m; i++) {
            if(m % i == 0) yaksu_m.add(i);
        }
        
        for(int i=0; i<(yaksu_n.size()<yaksu_m.size()?yaksu_n.size():yaksu_m.size()); i++) {
            if(yaksu_n.contains(yaksu_m.get(i)) && max_yaksu < yaksu_m.get(i)) {
                max_yaksu = yaksu_m.get(i);
            }
            if(yaksu_m.contains(yaksu_n.get(i)) && max_yaksu < yaksu_n.get(i)) {
                max_yaksu = yaksu_n.get(i);
            }
        }
        answer[0] = max_yaksu;
        
        for(int i=(n>m?n:m); i<=n*m; i++) {
            if(i % n == 0 && i % m == 0) {
                answer[1] = i;
                break;
            }
        }
        
        return answer;
    }
}