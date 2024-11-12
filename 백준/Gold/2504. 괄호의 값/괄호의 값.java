import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        Stack<String> stack = new Stack<>();
        boolean ok = true; // 올바른 괄호문자열인지 판단

        for(int i=0; i<str.length; i++) {
            if(str[i].equals("(") || str[i].equals("[")) { // 여는 괄호
                stack.add(str[i]);
            }
            else { // 닫는 괄호
                if(stack.isEmpty()) {
                    ok = false;
                    break;
                }
                int sum = 0;
                boolean small = str[i].equals(")");
                while(true) {
                    String data = stack.pop();

                    if(data.matches("^[0-9]*$")) { // 직전 값이 숫자?
                        sum += Integer.parseInt(data);
                        if(stack.isEmpty()) {
                            ok = false;
                            break;
                        }
                        continue;
                    }

                    if(small) { // ()
                        if(data.equals("(")) {
                            stack.add(sum == 0 ? "2" : String.valueOf(sum * 2));
                        }
                        else {
                            ok = false;
                        }
                        break;
                    }
                    else { // []
                        if(data.equals("[")) {
                            stack.add(sum == 0 ? "3" : String.valueOf(sum * 3));
                        }
                        else {
                            ok = false;
                        }
                        break;
                    }
                }
            }
        }

        int answer = 0;
        while(!stack.isEmpty()) {
            if(!ok) break;
            String data = stack.pop();
            if(data.matches("^[0-9]*$")) {
                answer += Integer.parseInt(data);
                continue;
            }
            answer = 0;
            break;
        }

        System.out.print(answer);
    }
}