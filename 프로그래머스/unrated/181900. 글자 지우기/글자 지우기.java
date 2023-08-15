class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        char[] c = my_string.toCharArray();
        
        for(int i:indices) c[i] = '0'; //indices 의 원소에 해당하는 인덱스 글자를 0으로 변경
        
        for(char k:c)
            if(k != '0') answer += String.valueOf(k); //0 값을 제외한 글자를 answer에 연결
        
        return answer;
    }
}