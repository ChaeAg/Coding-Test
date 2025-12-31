import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = arr[0];

        int left, right;
        int lastIdx = 1; // last DP Array Index
        for (int i = 1; i < N; i++) {
            left = 0;
            right = lastIdx;
            while (left < right) {
                int mid = (left + right) / 2;

                if (dp[mid] < arr[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            dp[left] = arr[i];
            lastIdx = Math.max(lastIdx, left + 1);
        }

        int cnt = 0;
        for (int i : dp) {
            if (i == 0) {
                break;
            }
            cnt++;
        }

        System.out.print(cnt);
    }
}