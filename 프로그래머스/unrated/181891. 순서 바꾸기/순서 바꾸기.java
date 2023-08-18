class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        int idx = 0;
        for(int i=n; i<num_list.length; i++){
            answer[idx] = num_list[i];
            idx++;
        }
        for(int k=0; k<n; k++){
            answer[idx] = num_list[k];
            idx++;
        }
        
        return answer;
    }
}