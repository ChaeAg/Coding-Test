class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;
        int start = 1;
        int idx = 1;
        while(start<=n) {
            sum += idx++;
            if(sum >= n) {
                if(sum == n) answer++;
                idx = ++start;
                sum = 0;
            }
        }
        
        return answer;
    }
}