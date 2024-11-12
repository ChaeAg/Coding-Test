class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int a = n % 3;

            if(a == 0) {
                sb.insert(0, 4);
                n--;
            }
            else {
                sb.insert(0, a);
            }
            
            n /= 3;
        }
        
        return sb.toString();
    }
}