import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        char[] array = br.readLine().toCharArray();
        
        for(char c: array){
            if(c < 48 || c > 58) { // 숫자가 아니면
                int b = stack.pop();
                int a = stack.pop();

                switch(c) {
                    case '+':
                        stack.push(a+b);
                        break;
                    case '-':
                        stack.push(a-b);
                        break;
                    case '*':
                        stack.push(a*b);
                        break;
                    case '/':
                        stack.push(a/b);
                        break;
                }
            }
            else stack.push(c - '0'); // 숫자가 맞으면
        }
        System.out.println(stack.pop());
    }
}
