import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] sums = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sums[i] = sums[i - 1] + Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 1;
        int minLen = N + 1;

        while (left < right) {
            if (right > N) {
                left++;
            } else if (sums[right] - sums[left] >= S) {
                minLen = Math.min(minLen, right - left);
                left++;
            } else {
                right++;
            }
        }

        System.out.print(minLen == N + 1 ? 0 : minLen);
    }
}