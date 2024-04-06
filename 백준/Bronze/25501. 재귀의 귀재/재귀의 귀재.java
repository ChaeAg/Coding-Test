import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            count = 0;
            String S = br.readLine();
            sb.append(isPalindrome(S)).append(" ").append(count).append("\n");
        }
        System.out.print(sb);
    }

    static int isPalindrome(String str) {
        return recursion(str.split(""), 0, str.length()-1);
    }

    static int recursion(String[] strs, int l, int r) {
        count++;
        if(l >= r) return 1;
        if(strs[l].equals(strs[r])) return recursion(strs, l+1, r-1);
        else return 0;
    }
}