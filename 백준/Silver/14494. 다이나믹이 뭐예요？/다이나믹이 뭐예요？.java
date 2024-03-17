import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dp = new long[n+1][m+1];
        System.out.print(dynamic(n, m));
    }
    static long dynamic(int x, int y) { // 탑다운 방식
        if(x == 1 && y == 1) return 1; // 1,1 은 경우의 수가 1
        if(x == 0 || y == 0) return 0; // 둘 중 하나라도 0에 갈수없기에 경우의 수 없음
        if(dp[x][y] != 0) return dp[x][y]; // 이미 경우의 수를 체크한 곳은 그냥 바로 return
        // 3가지 경우로 여기에 올 수 있는 경우의 수를 구함
        dp[x][y] = (dynamic(x, y-1) + dynamic(x-1, y) + dynamic(x-1, y-1)) % 1000000007;
        return dp[x][y];
    }
}