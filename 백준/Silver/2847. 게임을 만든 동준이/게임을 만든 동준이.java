import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        for(int i=0; i<N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for(int i=N-2; i>=0; i--) {
            while(scores[i] >= scores[i+1]) {
                scores[i]--;
                count++;
            }
        }

        System.out.print(count);
    }
}