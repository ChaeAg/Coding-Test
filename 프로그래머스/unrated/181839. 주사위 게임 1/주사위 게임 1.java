class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        boolean resulta = true, resultb = true;
        
        if(a % 2 == 0) resulta = false;
        if(b % 2 == 0) resultb = false;
        
        if(resulta && resultb) answer = a*a + b*b;
        else if(resulta || resultb) answer = (a+b) * 2;
        else {
            if(a > b) answer = a - b;
            else answer = b - a;
        }
        
        return answer;
    }
}