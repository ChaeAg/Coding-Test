class Solution {
    public long solution(int n) {
        long[] dp = new long[n];
        if(n == 1) return 1;
        if(n == 2) return 2;
        long num1 = 1;
        long num2 = 2;
        long temp;
        
        for(int i=3; i<=n; i++) {
            temp = num2;
            num2 = (num1 + num2) % 1234567;
            num1 = temp;
        }
        
        return num2;
    }
}