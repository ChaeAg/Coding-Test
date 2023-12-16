class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int i, j;
        if(num % 2 == 0) {
            answer[num/2 - 1] = total/num;
            i = num/2 - 2;
            j = num/2;
        }
        else {
            answer[num/2] = total/num;
            i = num/2 - 1;
            j = num/2 + 1;   
        }
        
        while(i >= 0 || j < num) {
            if(i >= 0) {
                answer[i] = answer[i+1] - 1;
                i--;
            }
            if(j < num) {
                answer[j] = answer[j-1] + 1;
                j++;
            }
        }
        
        
        return answer;
    }
}