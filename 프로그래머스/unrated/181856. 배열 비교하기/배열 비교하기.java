class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        int s1 = arr1.length, s2 = arr2.length;
        int sum1 = 0, sum2 = 0;
        
        if(s1 > s2) answer = 1;
        else if(s1 < s2) answer = -1;
        else{
            for(int i=0; i<s1; i++){
                sum1 += arr1[i];
                sum2 += arr2[i];
            }
        }
        if(sum1 > sum2) answer = 1;
        else if(sum1 < sum2) answer = -1;
        
        return answer;
    }
}