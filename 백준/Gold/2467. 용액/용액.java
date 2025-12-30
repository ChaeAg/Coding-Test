import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬 이분탐색 용
        Arrays.sort(nums);

        int left = 0;
        int right = N - 1;

        int nearResult = Math.abs(nums[left] + nums[right]);
        int[] leftAndRight = new int[2];
        leftAndRight[0] = nums[left];
        leftAndRight[1] = nums[right];

        while (left < right) {
            int nowResult = Math.abs(nums[left] + nums[right]);

            if (nowResult < nearResult) {
                nearResult = nowResult;
                leftAndRight[0] = nums[left];
                leftAndRight[1] = nums[right];
            }

            if (nums[left] + nums[right] < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.print(leftAndRight[0] + " " + leftAndRight[1]);
    }
}