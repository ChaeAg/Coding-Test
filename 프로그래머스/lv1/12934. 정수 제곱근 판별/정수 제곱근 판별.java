class Solution {
    public long solution(long n) {
        double num = Math.sqrt((double)n);
        
        if(num % 1 == 0.0) return (long)Math.pow(++num, 2);
        else return -1;
    }
}