import java.util.*;
class Solution {
    int[][] info;
    int n, m;
    int len;
    int min = 121;
    Set<String> str = new HashSet<>();
    public int solution(int[][] info, int n, int m) {
        this.info = info;
        this.n = n;
        this.m = m;
        len = info.length;
        
        dfs(0, 0, 0);
        
        return min == 121 ? -1 : min;
    }
    
    void dfs(int depth, int a, int b) {
        if(depth == len) {
            min = Math.min(min, a);
            return;
        }
        
        String s = depth+":"+a+":"+b;
        if(!str.add(s)) {
            return;
        }
        
        if(a + info[depth][0] < n && a + info[depth][0] < min) {
            dfs(depth+1, a + info[depth][0], b);
        }
        
        if(b + info[depth][1] < m) {
            dfs(depth+1, a, b + info[depth][1]);
        }
    }
}