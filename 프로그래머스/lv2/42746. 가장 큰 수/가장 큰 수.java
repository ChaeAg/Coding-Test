import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "", temp;
        String[] s = new String[numbers.length]; // numbers의 값을 넣을 스트링 배열
        
        for(int i=0; i<numbers.length; i++)//numbers의 값을 string으로 변환하여 s[]에 삽입
            s[i] = String.valueOf(numbers[i]); 
        
        Arrays.sort(s, Comparator.reverseOrder()); // 내림차순 정렬

        for(int i=0, k; i<s.length; i++){
            if(i != 0){ // 0일 때는 비교x
                k = i;
                // s[i]+s[i-1]가 s[i-1]+s[i] 크다면 s[i]를 s[i-1]의 앞으로 보내준다.
                while(Integer.parseInt(s[k]+s[k-1]) > Integer.parseInt(s[k-1]+s[k])){
                    temp = s[k];
                    s[k] = s[k-1];
                    s[k-1] = temp;
                    k--;
                    if(k == 0) break; // 인덱스가 0이 되면 반복문 탈출
                }
            }  
        }
        for(int i=0; i<s.length; i++) // 정렬 결과를 하나의 문자열로 합친다.
            answer += s[i];
        
        if(s[0].equals("0")) // 배열의 모든 값이 0이면 0을 리턴한다. (ex: 0000 -> 0)
            return "0";
        
        return answer;
    }
}
