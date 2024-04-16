import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] sum = new int[N];
        sum[0] = Integer.parseInt(st.nextToken());
        for(int idx=1; idx<N; idx++) {
            sum[idx] = sum[idx - 1] + Integer.parseInt(st.nextToken());
        }

        for(int count=0; count<M; count++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int result = sum[j-1];
            if(i != 1) result -= sum[i-2];
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}