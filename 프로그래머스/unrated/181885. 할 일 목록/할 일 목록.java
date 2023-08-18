class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        String[] answer;
        int count = 0;
        for(boolean b: finished)
            if(!b) count++;
        
        answer = new String[count];
        
        for(int i=0, idx=0; i<todo_list.length; i++){
            if(!finished[i]){
                answer[idx] = todo_list[i];
                idx++;
            } 
        }
        
        return answer;
    }
}