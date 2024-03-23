import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[] P = new long[101];
        P[1] = 1; P[2] = 1; P[3] = 1; P[4] = 2; P[5] = 2;
        int T = Integer.parseInt(br.readLine());
        int j = 5;
        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            while(j < N) {
                j++;
                if(P[j] != 0) continue;
                P[j] = P[j-1] + P[j-5];
            }
            sb.append(P[N]).append("\n");
        }
        System.out.print(sb);
    }
}