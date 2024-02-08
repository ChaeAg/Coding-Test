import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> table = new ArrayList(); // 상수 앞에 쌓이는 재료들
        
        for(int i=0; i<ingredient.length; i++) {
            table.add(ingredient[i]);
            int size = table.size();
            if(size > 3 && ingredient[i] == 1) { // 이번에 빵이 들어옴
                if(table.get(size-2)==3 && table.get(size-3)==2 && table.get(size-4)==1) { // 빵 야채 고기 빵 순으로 쌓임
                    answer++;
                    for(int j=0; j<4; j++) {
                        table.remove(table.size()-1); // 맨 뒤에서 재료 4개 삭제
                    }
                }
            }
        }
        
        return answer;
    }
}