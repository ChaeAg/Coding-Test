class Solution {
    public int solution(int num) {
        int count = 0;      
        Long n = Long.valueOf(num);
        
        while(n != 1) {
            if(n % 2 == 0) {
                n /= 2;
            }
            else {
                n = n * 3 + 1;
            }
            count++;
            if(count > 500) return -1;
        }
        
        return count;
    }
}