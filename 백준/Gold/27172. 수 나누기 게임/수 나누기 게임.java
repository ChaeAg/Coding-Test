import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, nums[i]);
        }

        int[] index = new int[max + 1];
        Arrays.fill(index, -1);
        for (int i = 0; i < N; i++) {
            index[nums[i]] = i;
        }

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = nums[i] * 2; j <= max; j += nums[i]) {
                if (index[j] > -1) {
                    result[i]++;
                    result[index[j]]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }
        System.out.print(sb);
    }
}