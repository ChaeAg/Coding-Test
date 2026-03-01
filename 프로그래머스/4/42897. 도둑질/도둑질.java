class Solution {
    public int solution(int[] money) {
        int len = money.length;
        
        // 첫번째 집 선택O
        int take1 = 0;
        int skip1 = money[0];
        
        // 첫번째 집 선택X
        int take2 = money[1];
        int skip2 = 0;
        
        for(int i=2; i<len; i++) {
            if(i == len-1) {
                skip1 = Math.max(take1, skip1);
                take1 = 0;
            } else {
                int tmp = skip1;
                skip1 = Math.max(take1, skip1);
                take1 = tmp + money[i];    
            }
            int tmp = skip2;
            skip2 = Math.max(take2, skip2);
            take2 = tmp + money[i];
        }
        
        return Math.max(Math.max(skip1, take1), Math.max(skip2, take2));
    }
}