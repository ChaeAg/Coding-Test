class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        String str = "";
        int idx = 0;
        for(String word : s.split("")) {
            if(str.lastIndexOf(word) != -1) {
                answer[idx] = idx - str.lastIndexOf(word);
            }
            else {
                answer[idx] = -1;
            }
            str += word;
            idx++;
        }
        return answer;
    }
}