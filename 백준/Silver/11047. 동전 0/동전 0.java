import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] money = new int[N];

        for(int i=N-1; i>=0; i--) { // 내림차순으로 베열에 담음
            money[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for(int i=0; i<N; i++) {
            count += K / money[i];
            K = K % money[i];
        }

        System.out.print(count);
    }
}