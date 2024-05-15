import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String s) {
        String[] arr = s.split("");
        List<List<String>> tuple = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int idx = 1;
        String str = "";

        while(idx < s.length()-1) {
            if(arr[idx].equals("{")) { // 리스트 시작
                temp = new ArrayList<>();
                str = "";
            }
            else if(arr[idx].equals("}")) { // 리스트 끝
                temp.add(str);
                tuple.add(temp);
            }
            else if(arr[idx].equals(",")) { // 새로운 수 또는 새로운 리스트 등장
                if(!arr[idx+1].equals("{")) { // 새로운 수 등장일 경우
                    temp.add(str); // 직전 수 저장
                    str = ""; // 초기화
                }
            }
            else { // 숫자일 경우
                str += arr[idx];
            }
            idx++;
        }

        // 내부 리스트의 사이즈로 오름차순 정렬
        List<List<String>> sort_tuple = tuple.stream()
                .sorted(Comparator.comparingInt(List::size))
                .collect(Collectors.toList());

        int size = sort_tuple.get(sort_tuple.size()-1).size(); // 길이가 가장 긴 리스트 크기가 튜플 크기가 됨
        int[] answer = new int[size];
        answer[0] = Integer.parseInt(sort_tuple.get(0).get(0));

        for(int i=1; i<sort_tuple.size(); i++) {
            List<String> now = new ArrayList<>(sort_tuple.get(i));
            List<String> before = List.copyOf(sort_tuple.get(i-1));

            now.removeAll(before); // now - before = 새로운 수 1개

            answer[i] = Integer.parseInt(now.get(0));
        }
        
        return answer;
    }
}