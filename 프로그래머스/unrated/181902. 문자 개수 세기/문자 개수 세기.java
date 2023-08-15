class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52]; 
        char[] c = my_string.toCharArray();
        
        for(int i=0; i<c.length; i++){
            // c[i]가 대문자일 경우 65를 빼주면 아스키코드로 0을 가리킴.
            if(Character.isUpperCase(c[i])) answer[(int)c[i] - 65]++;
            // c[i]가 소문자일 경우 71을 빼주면 아스키코드로 17을 가리킴.
            else answer[(int)c[i] - 71]++;
        }
        
        return answer;
    }
}