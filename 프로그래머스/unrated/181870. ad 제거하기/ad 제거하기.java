class Solution {
    public String[] solution(String[] strArr) {
        String[] list = new String[strArr.length];
        int idx=0;
        
        for(String a:strArr){
            if(!a.contains("ad")){
                list[idx] = a;
                idx++;
            }
        }
        String[] answer = new String[idx];
        for(int i=0; i<idx; i++){
            answer[i] = list[i];
        }
        
        return answer;
    }
}