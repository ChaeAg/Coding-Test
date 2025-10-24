import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];

        long max_tree = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            max_tree = Math.max(max_tree, arr[i]);
        }

        long left = 0, right = max_tree;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            long cnt = 0;

            for (long i : arr) {
                if (mid >= i) {
                    continue;
                }
                cnt += i - mid;
            }

            if (cnt >= M) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.print(answer);
    }
}