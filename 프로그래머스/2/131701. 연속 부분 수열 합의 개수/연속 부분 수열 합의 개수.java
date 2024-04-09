import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> sums = new HashSet<>();
        int len = elements.length;
        
        for(int i=0; i<len; i++) { // 더할 개수
            for(int j=0; j<len; j++) { // 시작 인덱스
                int sum = 0;
                for(int k=0; k<=i; k++) { // 진짜 더하는 for문
                    sum += elements[(j+k) % len];
                }
                sums.add(sum);
            }
        }
        
        return sums.size();
    }
}