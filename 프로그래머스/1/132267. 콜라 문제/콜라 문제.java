class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n >= a) {
            int jibulCola = (n / a) * a;
            int getCola = (n / a) * b;
            n = n - jibulCola + getCola;
            answer += getCola;
        }
        
        return answer;
    }
}