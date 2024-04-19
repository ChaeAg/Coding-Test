import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(A);

        int[] sum = new int[N];
        sum[0] = A[0];
        for(int i=1; i<N; i++) {
            sum[i] = sum[i-1] + A[i];
        }

        for(int count=0; count<Q; count++) {
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