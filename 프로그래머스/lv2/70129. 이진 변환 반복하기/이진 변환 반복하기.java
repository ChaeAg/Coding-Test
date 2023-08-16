class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")){
            String[] ss = s.split("");
            String result = "";
            for(String i:ss){
                if(i.equals("1")) result += i;
                else answer[1]++;
            }
            s = Integer.toBinaryString(result.length());
            answer[0]++;
        }
        
        return answer;
    }
}