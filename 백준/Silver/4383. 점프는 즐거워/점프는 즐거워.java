import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = null;
        while(true) {
            str = br.readLine();
            if(str == null || str.isEmpty()) break;
            StringTokenizer st = new StringTokenizer(str, " ");
            int n = Integer.parseInt(st.nextToken());
            boolean[] result = new boolean[n];
            int[] nums = new int[n];
            for(int i=0; i<n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
                if(i > 0) {
                    int cha = Math.abs(nums[i] - nums[i-1]);
                    if(cha > 0 && cha < n) result[cha] = true;
                }
            }

            sb.append(isJolly(result)).append("\n");
        }
        System.out.print(sb);
    }

    public static String isJolly(boolean[] result) {
        for (int i=1; i< result.length; i++) {
            if (!result[i])
                return "Not jolly";
        }
        return "Jolly";
    }
}