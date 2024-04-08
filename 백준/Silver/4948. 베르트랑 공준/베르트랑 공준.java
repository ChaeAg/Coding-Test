import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] isPrime = new boolean[2469134+1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        int n, before_n = 0;
        while((n = Integer.parseInt(br.readLine())) != 0) {
            if(before_n < n) {
                for(int i=2; i<=Math.sqrt(n*2); i++) {
                    if(!isPrime[i]) continue;

                    for(int j=i*i; j<=n*2; j+=i) {
                        isPrime[j] = false;
                    }
                }
            }
            int count = 0;
            for(int i=n+1; i<=n*2; i++) {
                if(isPrime[i]) count++;
            }
            sb.append(count).append("\n");
            before_n = n;
        }

        System.out.print(sb);
    }
}