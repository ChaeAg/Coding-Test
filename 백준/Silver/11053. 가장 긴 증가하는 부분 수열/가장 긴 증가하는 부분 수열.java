import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        int[] result = new int[N];
        int lastIdx = 0;
        result[0] = nums[0];

        for (int i = 1; i < N; i++) {
            if (result[lastIdx] > nums[i]) { // 이분탐색 시작!
                int left = 0;
                int right = lastIdx;

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (result[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                result[left] = nums[i];
            } else if (result[lastIdx] < nums[i]) {
                result[++lastIdx] = nums[i];
            }
        }

        System.out.print(lastIdx + 1);
    }
}