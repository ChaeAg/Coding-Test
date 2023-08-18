class Solution {
    public int[] solution(int [] arr) {
        int[] answer;
        int first=-1, last=0, count=0, idx=0;
        
        for(int i:arr){
            if(i == 2 && first == -1) { // arr[ids]가 2고 처음 2가 발견되었다면
                first = idx;
                last = first;
            }
            else if (i == 2) last = idx;
            idx++;
        }
        if(first == -1){ // arr에 2가 없을 때
            answer = new int[1];
            answer[0] = -1;
        }
        else{
            answer = new int[last - first + 1];
            for(int i=first, k=0; i<=last; i++, k++){
                answer[k] = arr[i];
            }
        } 
        
        return answer;
    }
}