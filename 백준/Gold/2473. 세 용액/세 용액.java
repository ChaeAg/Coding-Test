import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr); // 오름차순정렬

        long minSum = Long.MAX_VALUE;
        long[] result = new long[3];

        for (int i = 1; i < N - 1; i++) {
            int left = 0;
            int right = N - 1;

            while (left < right) {
                long sum = arr[left] + arr[i] + arr[right];

                if (left != i && i != right) {
                    if (Math.abs(sum) < minSum) {
                        minSum = Math.abs(sum);
                        result[0] = arr[left];
                        result[1] = arr[i];
                        result[2] = arr[right];
                    }
                }

                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        Arrays.sort(result);

        StringBuilder sb = new StringBuilder();
        for (long i : result) {
            sb.append(i).append(" ");
        }

        System.out.print(sb);
    }
}