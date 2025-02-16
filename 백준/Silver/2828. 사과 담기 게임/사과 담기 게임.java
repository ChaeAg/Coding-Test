import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        int M = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(br.readLine());

        int now_l = 1, now_r = M, distance = 0;
        for (int i = 0; i < J; i++) {
            int p = Integer.parseInt(br.readLine());
            if (p < now_l) {
                int d = now_l - p;
                distance += d;
                now_l = p;
                now_r -= d;
            } else if (p > now_r) {
                int d = p - now_r;
                distance += d;
                now_l += d;
                now_r = p;
            }
        }

        System.out.print(distance);
    }
}