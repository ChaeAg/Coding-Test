import java.util.*;
class Solution {
    public List<Long> solution(long n) {
        List<Long> list = new ArrayList();
        
        while(n >= 1){
            list.add(n % 10);
            n /= 10;
        }
        
        return list;
    }
}