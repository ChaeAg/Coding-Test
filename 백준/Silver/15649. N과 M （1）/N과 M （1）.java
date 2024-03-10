import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[N+1];
        bt(0);
    }

    static void bt(int num) {
        if(num == M) {
            System.out.println(sb);
            return;
        }
        for(int i=1; i<=N; i++) {
            if(!check[i]) {
                check[i] = true;
                sb.append(i).append(" ");
                bt(num+1);
                check[i] = false;
                sb.setLength(sb.length() - 2);
            }
        }
    }
}