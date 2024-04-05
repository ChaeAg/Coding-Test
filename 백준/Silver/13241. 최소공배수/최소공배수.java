import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long max = A > B ? A : B;
        long min = A < B ? A : B;

        while(min > 0) {
            long temp = min;
            min = max % min;
            max = temp;
        }

        System.out.print(A*B/max);
    }
}