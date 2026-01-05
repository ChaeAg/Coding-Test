import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split("");
        String[] str2 = br.readLine().split("");

        int[][] dp = new int[str1.length + 1][str2.length + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (str1[i - 1].equals(str2[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        System.out.println(dp[str1.length][str2.length]);

        int i = str1.length;
        int j = str2.length;

        while (i > 0 && j > 0) {
            if (str1[i - 1].equals(str2[j - 1])) {
                sb.append(str1[i - 1]);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.print(sb.reverse());
    }
}