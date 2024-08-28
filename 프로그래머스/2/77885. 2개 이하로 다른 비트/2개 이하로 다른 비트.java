class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i=0; i<numbers.length; i++) {
            String[] strs = Long.toBinaryString(numbers[i]).split("");
            String result = "";
            for(int j=strs.length-1; j>=0; j--) {
                if(strs[j].equals("0")) {
                    strs[j] = "1";
                    if(j < strs.length-1) strs[j+1] = "0";
                    result = String.join("", strs);
                    break;
                }

                if(j == 0) { // 2진수의 모든 비트가 1일 경우에 여기 도달
                    strs[j] = "0";
                    result = "1" + String.join("", strs);
                }
            }
            answer[i] = Long.parseLong(result, 2);
        }
        
        return answer;
    }
}