import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        long result = 1;

        while (B > 0) {
            if (B % 2 == 1) { // B가 홀수
                result = (result * A) % C;
                B--;
            }
            A = (A * A) % C;
            B /= 2;
        }

        System.out.print(result);
    }
}