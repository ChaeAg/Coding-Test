class Solution {
    public String[] solution(String my_string) {
        String[] answer = new String[my_string.length()];
        String temp;
        int s;
        
        for(int i=my_string.length()-1, j=0; i>=0; i--,j++){
            answer[j] = my_string.substring(i, my_string.length());
            s = j;
            for(int k=1; k<my_string.length()-i; k++){
                if(answer[s].compareTo(answer[s-1]) < 0){
                    temp = answer[s-1];
                    answer[s-1] = answer[s];
                    answer[s] = temp;
                    s--;
                }
            }
        }
        
        return answer;
    }
}