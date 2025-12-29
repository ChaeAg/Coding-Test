import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.print(pibo(n));
    }

    static long pibo(long num) {
        if (num == 1) {
            return 1;
        }
        if (num == 2) {
            return 1;
        }

        if (memo.containsKey(num)) {
            return memo.get(num);
        }

        long result;

        if (num % 2 == 0) {
            long t = num / 2;
            result = (pibo(t) * ((pibo(t - 1) + pibo(t + 1)) % 1000000007)) % 1000000007;
        } else {
            long t = num / 2;
            long pibo_result = pibo(t) % 1000000007;
            long pibo_result2 = pibo(t + 1) % 1000000007;
            result = ((pibo_result * pibo_result) % 1000000007 + (pibo_result2 * pibo_result2) % 1000000007)
                    % 1000000007;
        }

        memo.put(num, result);
        return result;
    }
}