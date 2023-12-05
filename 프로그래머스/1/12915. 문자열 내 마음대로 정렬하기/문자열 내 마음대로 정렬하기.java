import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings); // 나중에 n인덱스 자리 문자가 똑같을 경우 구분하기 위해 처음에 오름차순 정렬 해줌
        
        String[] answer = new String[strings.length]; // 정답을 담을 배열
        String[] arr = new String[strings.length]; // n 인덱스 자리 문자를 잘라서 저장할 배열
        
        for(int i=0; i<strings.length; i++) {
            arr[i] = String.valueOf(strings[i].charAt(n)); // n 인덱스 자리 문자를 잘라서 저장
        }
        Arrays.sort(arr); // n 인덱스 자리 문자가 담긴 배열을 오름차순 정렬
        List<String> strList = new ArrayList<>(Arrays.asList(strings));

        for(int i=0; i<arr.length; i++) { // 최종 오름차순으로 정렬된 n 인덱스 자리 문자들로 기존 문자열 리스트를 탐색한다.
            for(int k=0; k<strList.size(); k++) {
                if(strList.get(k).charAt(n) == arr[i].charAt(0)) { // 순차적으로 탐색할 때, 오름차순으로 정렬되어 있으니, 같으면 바로 해당 문자열의 n 인덱스 자리 문자인 것임.
                    answer[i] = strList.get(k);
                    strList.remove(k);
                    break;
                }
            }
        }
        
        return answer;
    }
}