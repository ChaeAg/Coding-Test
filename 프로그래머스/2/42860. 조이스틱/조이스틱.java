import java.util.*;

class Solution {
    // 처음 문자 AAA, AAAA ...
    /**
    * 선택할 수 있는 행동들
    * 1. 다음 알파벳 (A -> B, Z -> A)
    * 2. 이전 알파벳 (A -> Z, B -> A)
    * 3. 커서 오른쪽으로 이동 (idx-0 -> idx-1)
    * 4. 커서 왼쪽으로 이동 (idx-0 -> idx-(len-1))
    */
    public int solution(String name) { // name = "JEROEN", now = 0
        int answer = 0;
        int len = name.length();
        int move = len-1;
        char[] name_arr = name.toCharArray();
        int y;
        
        for(int x=0; x<len; x++) {
            answer += Math.min(name_arr[x] - 'A', 'Z' - name_arr[x] + 1);
            
            y = x + 1;
            while(y < len && name_arr[y] == 'A') {
                y++;
            }
            
            move = Math.min(move, (Math.min(x + x + len-y, len-y + len-y + x)));
        }
        
        return move + answer;
    }
}