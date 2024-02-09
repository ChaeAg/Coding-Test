import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] B = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(A);
        Arrays.sort(B);
        int result = S(N, A, B);
        System.out.print(result);
    }

    private static int S(int N, int[] A, int[] B) {
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += A[i] * B[N - i - 1];
        }

        return sum;
    }
}