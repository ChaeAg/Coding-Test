import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.print(0);
            return;
        }
        
        List<Long> sosuList = searchRangeOfSosu(N);
        int sosuCount = sosuList.size();

        long[] sosuSums = new long[sosuCount + 1];
        for (int i = 1; i <= sosuCount; i++) {
            sosuSums[i] = sosuSums[i - 1] + sosuList.get(i - 1);
        }

        int result = 0;
        int left = 0, right = 1;
        while (left < right) {
            long cha = sosuSums[right] - sosuSums[left];
            if (cha < N) {
                right++;
            } else if (cha > N) {
                left++;
            } else {
                result++;
                right++;
            }

            if (right > sosuCount) {
                left++;
                right--;
            }
        }

        System.out.print(result);
    }

    static List<Long> searchRangeOfSosu(int N) {
        List<Long> sosuList = new ArrayList<>();
        boolean[] isNotSosu = new boolean[N + 1];

        for (long i = 2; i <= N; i++) {
            if (isNotSosu[(int) i]) {
                continue;
            }

            sosuList.add(i);
            for (long j = 2; i * j <= N; j++) {
                isNotSosu[(int) (i * j)] = true;
            }
        }

        return sosuList;
    }
}