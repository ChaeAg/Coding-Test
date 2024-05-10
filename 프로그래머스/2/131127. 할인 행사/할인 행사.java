import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        List<String> want_list = Arrays.asList(want);
        
        for(int i=0; i<=discount.length-10; i++) {
            int[] copy_number = Arrays.copyOf(number, number.length);
            for(int idx=i; idx<i+10; idx++) {
                if(want_list.contains(discount[idx])) {
                    int index = want_list.indexOf(discount[idx]);
                    copy_number[index]--;
                }
            }
            boolean isOk = true;
            for(int num : copy_number) {
                if(num > 0) {
                    isOk = false;
                    break;
                } 
            }
            
            if(isOk) answer++;
        }
        
        return answer;
    }
}