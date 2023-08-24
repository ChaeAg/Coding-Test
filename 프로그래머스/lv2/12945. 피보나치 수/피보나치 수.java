class Solution {
    public int solution(int n) {
        int f0 = 0, f1 = 1, f2 = 0;        
        int count = 1;
        
        while(count != n){
            f2 = (f0 + f1) % 1234567;
            f0 = f1;
            f1 = f2;
            count++;
        }
        return f2;
    }
}