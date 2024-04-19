import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer,Integer> m = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);

        for(int i = 0; i < A.length; i++){
            if(m.get(A[i]) == null){
                m.put(A[i], i);
            }
        }

        for(int i = 0; i < M; i++){
            int q = Integer.parseInt(br.readLine());
            if(m.get(q) == null) sb.append(-1).append("\n");
            else sb.append(m.get(q)).append("\n");
        }
        System.out.print(sb);
    }
}