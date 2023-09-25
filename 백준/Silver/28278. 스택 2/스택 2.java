import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String command;

        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        StringTokenizer st;
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();

            if(command.equals("1")) {
                stack.push(Integer.parseInt(st.nextToken()));
            }
            else if(command.equals("2")) {
                if(stack.empty()) result.append(-1 + "\n");
                else {
                    result.append(stack.peek() + "\n");
                    stack.pop();
                }
            }
            else if(command.equals("3")) {
                result.append(stack.size() + "\n");
            }
            else if(command.equals("4")) {
                if(stack.empty()) result.append(1 + "\n");
                else result.append(0 + "\n");
            }
            else if(command.equals("5")) {
                if(stack.empty()) result.append(-1 + "\n");
                else result.append(stack.peek() + "\n");
            }
        }

        System.out.println(result);
        br.close();
    }
}
