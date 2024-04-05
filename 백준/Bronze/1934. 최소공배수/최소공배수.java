import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int max = A > B ? A : B;
            int min = A < B ? A : B;
            while(min > 0) {
                int temp = min;
                min = max % min;
                max = temp;
            }
            sb.append(A*B/max).append("\n");
        }

        System.out.print(sb);
    }
}