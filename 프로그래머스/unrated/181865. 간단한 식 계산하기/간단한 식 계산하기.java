class Solution {
    public int solution(String binomial) {
        int answer=0;
        String[] s = binomial.split(" ");
        int num1 = Integer.parseInt(s[0]);
        int num2 = Integer.parseInt(s[2]);
        
        switch(s[1]){
            case "+":
                answer = num1 + num2;
                break;
            case "-":
                answer = num1 - num2;
                break;
            case "*":
                answer = num1 * num2;
                break;
        }
         
        return answer;
    }
}