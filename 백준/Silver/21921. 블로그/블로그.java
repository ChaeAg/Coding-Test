import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] visitors = new int[N];
        int[] sums = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
            sums[i + 1] = sums[i] + visitors[i];
        }

        int max = 0, count = 0;

        for (int start = 0; start <= N - X; start++) {
            int sum = sums[start + X] - sums[start];
            
            if (max == sum) {
                count++;
            } else if (max < sum) {
                count = 1;
                max = sum;
            }
        }

        System.out.print(max == 0 ? "SAD" : max + "\n" + count);
    }
}