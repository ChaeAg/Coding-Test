import java.io.*;
import java.util.Stack;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split("");

        Stack<String> operandStack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        int idx = 0;

        while (idx < strs.length) {
            if (strs[idx].matches("[A-Z]")) { // 피연산자인지
                sb.append(strs[idx++]);
            } else { // 연산자인지
                String now = strs[idx++];

                if (now.equals("+") || now.equals("-")) {
                    while (!operandStack.isEmpty() && !operandStack.peek().equals("(")) {
                        sb.append(operandStack.pop());
                    }
                    operandStack.push(now);
                } else if (now.equals("*") || now.equals("/")) {
                    while (!operandStack.isEmpty() && !operandStack.peek().equals("(")
                            && (operandStack.peek().equals("*") || operandStack.peek().equals("/"))) {
                        sb.append(operandStack.pop());
                    }
                    operandStack.push(now);
                } else if (now.equals(")")) {
                    while (!operandStack.peek().equals("(")) {
                        sb.append(operandStack.pop());
                    }
                    operandStack.pop(); // 여는 괄호까지 pop
                } else if (now.equals("(")) {
                    operandStack.push(now);
                }
            }
        }

        while (!operandStack.isEmpty()) {
            sb.append(operandStack.pop());
        }

        System.out.print(sb);
    }
}