class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i=1; i<=number; i++) {
            int divisorCount = 0;
            for(int j=1; j*j<=i; j++) {
                if(j * j == i) divisorCount++;
                else if(i % j == 0) divisorCount += 2;
            }
            if(divisorCount > limit) answer += power;
            else answer += divisorCount;
        }
        
        return answer;
    }
}