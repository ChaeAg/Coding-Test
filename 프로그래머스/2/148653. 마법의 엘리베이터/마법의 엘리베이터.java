class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0) {
            int one = storey % 10;
            storey /= 10;
            
            if(one > 5) { // 올림
                answer += (10 - one);
                storey++;
            }
            else if(one < 5) { // 내림
                answer += one;
            }
            else {
                if(storey % 10 >= 5) {
                    storey++;
                }
                answer += one;
            }
        }
        
        return answer;
    }
}