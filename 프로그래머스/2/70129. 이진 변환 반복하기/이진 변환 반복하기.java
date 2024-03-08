class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")) {
            int cut_s_len = s.replaceAll("0", "").length();
            answer[1] += s.length() - cut_s_len;
            s = Integer.toBinaryString(cut_s_len);
            answer[0]++;
        }
        
        return answer;
    }
}