import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        if (str1.length() < str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        int len1 = str1.length();
        int len2 = str2.length();

        int[][] arr = new int[len2 + 1][len1 + 1];

        for (int i = 1; i <= len2; i++) {
            char str1_c = str2.charAt(i - 1);
            for (int j = 1; j <= len1; j++) {
                arr[i][j] = str1_c == str1.charAt(j - 1) ? arr[i - 1][j - 1] + 1 : Math.max(arr[i][j - 1], arr[i - 1][j]);
            }
        }

        System.out.print(arr[len2][len1]);
    }
}