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
        int[] pies = new int[N];
        int[] sums = new int[N*2];

        st = new StringTokenizer(br.readLine());
        int idx = 0;
        sums[idx] = pies[idx++] = Integer.parseInt(st.nextToken());

        while(idx < N*2) {
            if(idx < N) pies[idx] = Integer.parseInt(st.nextToken());
            sums[idx] = sums[idx-1] + pies[idx % N];
            idx++;
        }

        int max = 0;
        for(int i=0; i<N*2-K; i++) {
            int sum = sums[i+K] - sums[i];
            max = sum > max ? sum : max;
        }

        System.out.print(max);
    }
}