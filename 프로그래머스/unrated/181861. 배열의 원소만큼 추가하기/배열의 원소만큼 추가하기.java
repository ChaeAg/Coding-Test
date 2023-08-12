class Solution {
    public int[] solution(int[] arr) {
        int idx = 0;
        for(int k:arr) idx += k;
        
        int[] answer = new int[idx];
        
        for(int i=0, a=0; i<arr.length; i++){
            for(int j=0; j<arr[i]; j++) {
                answer[a] = arr[i]; 
                a++;
            }
        }
        
        return answer;
    }
}