import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> b_s = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int[] b_a = new int[N];
        b_a[0] = Integer.parseInt(br.readLine());
        b_s.add(0);
        long count = 0;
        int idx = 1;

        while(idx < N) {
            int b = Integer.parseInt(br.readLine());
            b_a[idx] = b;
            while(!b_s.isEmpty() && b_a[b_s.peek()] <= b) {
                count += (idx - b_s.pop() - 1);
            }
            b_s.add(idx++);
        }

        while(!b_s.isEmpty()) { // 스택에 값이 다 없어질 때까지
            count += (idx - b_s.pop() - 1);
        }

        System.out.print(count);
    }
}