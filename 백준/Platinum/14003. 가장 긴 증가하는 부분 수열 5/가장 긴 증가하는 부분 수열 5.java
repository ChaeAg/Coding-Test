import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        int[] cnt = new int[N];
        dp[0] = nums[0];
        cnt[0] = 1;
        int dpIdx = 1;
        int maxCnt = 1;

        for (int i = 1; i < N; i++) {
            int num = nums[i];

            int left = 0;
            int right = dpIdx;

            while (left < right) {
                int mid = (left + right) / 2;

                if (dp[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            dp[left] = num;
            cnt[i] = left + 1;
            maxCnt = Math.max(cnt[i], maxCnt);
            if (dpIdx == left) {
                dpIdx++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxCnt).append("\n");

        Stack<Integer> s = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            if (cnt[i] == maxCnt) {
                s.push(nums[i]);
                maxCnt--;
            }
        }

        while (!s.isEmpty()) {
            sb.append(s.pop()).append(" ");
        }

        System.out.print(sb);
    }
}