class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {-1, -1};
        int pointer1 = 0, pointer2 = 0;
        int len = sequence.length;
        int sum = sequence[pointer1];
        
        while(pointer1 < len-1) {
            if(pointer2 == len-1 || sum > k) {
                sum -= sequence[pointer1];
                pointer1++;
            }
            else if(sum < k) {
                pointer2++;
                sum += sequence[pointer2];
            }

            if(sum == k) {
                if(answer[0] == -1 && answer[1] == -1 || answer[1]-answer[0] > pointer2-pointer1) {
                    answer[0] = pointer1;
                    answer[1] = pointer2;
                }
                if(pointer2 < len-1) {
                    pointer2++;
                    sum += sequence[pointer2];
                }
            }
        }
        
        return answer;
    }
}