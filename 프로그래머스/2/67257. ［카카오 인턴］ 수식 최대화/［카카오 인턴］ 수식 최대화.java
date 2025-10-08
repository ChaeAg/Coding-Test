import java.util.*;

class Solution {
    static long max_benefit = 0;
    static String arr[];
    public long solution(String expression) {
        arr = expression.split("");
        String[] op = new String[3];
        int t = 0;
        int len = arr.length;
        
        if(expression.replace("+", "").length() != len) {
            op[t++] = "+";
        }
        if(expression.replace("-", "").length() != len) {
            op[t++] = "-";
        }
        if(expression.replace("*", "").length() != len) {
            op[t++] = "*";
        }
        
        for(int i=0; i<t; i++) {
            if(t > 1) {
                for(int j=0; j<t; j++) {
                    if(i == j) continue;
                    if(t > 2) {
                        for(int k=0; k<t; k++) {
                            if(i == k || j == k) continue;
                            benefit_calculator(Arrays.asList(op[i], op[j], op[k]));
                        }
                    }
                    else benefit_calculator(Arrays.asList(op[i], op[j]));
                }
            }
            else benefit_calculator(Arrays.asList(op[i]));
        }
        
        return max_benefit;
    }
    
    public void benefit_calculator(List<String> operators) {
        String numStr = "";
        Stack<Long> num_stack = new Stack<>();
        Stack<String> op_stack = new Stack<>();
        for(int i=0; i<arr.length; i++) {
            if(operators.contains(arr[i])) { // 연산자
                num_stack.push(Long.parseLong(numStr));
                
                // 연산자 스택에 넣거나 연산하기
                while(true) {
                    if(op_stack.isEmpty()) {
                        op_stack.push(arr[i]);
                        break;
                    }
                    
                    if(operators.indexOf(op_stack.peek()) <= operators.indexOf(arr[i])) {
                        // 숫자 스택과 연산
                        long num2 = num_stack.pop();
                        long num1 = num_stack.pop();
                        String op = op_stack.pop();
                        
                        if(op.equals("+")) {
                            num_stack.push(num1+num2);
                        }
                        else if(op.equals("-")) {
                            num_stack.push(num1-num2);
                        }
                        else {
                            num_stack.push(num1*num2);
                        }
                    }
                    
                    if(op_stack.isEmpty() || operators.indexOf(op_stack.peek()) > operators.indexOf(arr[i])) { // 연산자 스택 또 검증
                        op_stack.push(arr[i]);
                        break;
                    }
                }
                
                numStr = ""; // 숫자 초기화
            }
            else { // 숫자 일부
               numStr += arr[i]; 
            }
        }
        
        num_stack.push(Long.parseLong(numStr));
        
        while(!op_stack.isEmpty()) {
            long num2 = num_stack.pop();
            long num1 = num_stack.pop();
            String op = op_stack.pop();
        
            if(op.equals("+")) {
                num_stack.push(num1+num2);
            }
            else if(op.equals("-")) {
                num_stack.push(num1-num2);
            }
            else {
                num_stack.push(num1*num2);
            }
        }
        
        long result = Math.abs(num_stack.pop());

        if(max_benefit == 0 || max_benefit < result) {
            max_benefit = result;
        }
    }
}