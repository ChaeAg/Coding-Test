import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] person = new int[N][2];
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            String[] p = br.readLine().split(" ");
            person[i][0] = Integer.parseInt(p[0]);
            person[i][1] = Integer.parseInt(p[1]);
        }

        for(int i=0; i<N; i++) {
            int rank = 1;
            for(int j=0; j<N; j++) {
                if(i == j) continue;
                if(person[i][0] < person[j][0] && person[i][1] < person[j][1]) {
                    rank++;
                }
            }
            result[i] = rank;
        }

        for(int rank : result) {
            sb.append(rank).append(" ");
        }
        System.out.print(sb);
    }
}