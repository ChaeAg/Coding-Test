import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        System.out.print(greedy(S));
    }

    static long greedy(long num) {
        if(num == 2 || num == 1) return 1;
        long sum = 0, count = 0;
        for(long i=1; i<=num/2; i++) {
            sum += i;
            count++;
            if(sum + i + i + 3 >= num) {
                return sum + i + i + 3 == num ? count + 2 : count + 1;
            }
        }
        return 0;
    }
}