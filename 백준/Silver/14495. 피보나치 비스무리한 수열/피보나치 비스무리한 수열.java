import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] fibo = new long[117];
        fibo[1] = 1;
        fibo[2] = 1;
        fibo[3] = 1;

        for(int i=4; i<=n; i++) {
            fibo[i] = fibo[i-1] + fibo[i-3];
        }

        System.out.print(fibo[n]);
    }
}