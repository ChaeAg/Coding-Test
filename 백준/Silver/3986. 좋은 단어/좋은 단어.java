import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=0; i<N; i++) {
            Stack<String> stack = new Stack<>();
            String str = br.readLine();

            for(int j=0; j<str.length(); j++) {
                String s = str.substring(j, j+1);
                if(!stack.isEmpty() && s.equals(stack.peek())) {
                    stack.pop();
                    continue;
                }
                stack.push(s);
            }

            if(stack.isEmpty()) count++;
        }

        System.out.print(count);
    }
}