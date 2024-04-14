import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> t_s = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int[] t_a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int idx = N-1;
        t_s.add(idx--);
        int[] result = new int[N];

        while(idx < N && idx >= 0) {
            while(!t_s.isEmpty() && t_a[t_s.peek()] <= t_a[idx]) {
                result[t_s.pop()] = idx + 1;
            }
            t_s.add(idx--);
        }

        while(idx >= 0) { // 스택에 값이 다 없어질 때까지
            result[idx--] = 0;
        }

        for(int i=0; i<N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.print(sb);
    }
}