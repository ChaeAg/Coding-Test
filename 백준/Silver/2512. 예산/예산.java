import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = max < arr[i] ? arr[i] : max;
        }

        int M = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left = 0, right = max, max_result = 0, answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for (int i : arr) {
                sum += i < mid ? i : mid;
            }

            if (sum > M) {
                right = mid - 1;
                continue;
            }

            if (max_result <= sum) {
                answer = Math.max(answer, mid);
                max_result = sum;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.print(answer);
    }
}