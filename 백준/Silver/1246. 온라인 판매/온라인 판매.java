import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] eggs = new int[M];
        for (int i = 0; i < M; i++) {
            eggs[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(eggs);
        
        int price = 0, count = 0;
        for (int i = 0; i < M; i++) {
            int c = Math.min(N, M - i);
            int p = eggs[i] * c;
            if (price * count < p) {
                price = eggs[i];
                count = c;
            }
        }

        System.out.print(price + " " + price * count);
    }
}