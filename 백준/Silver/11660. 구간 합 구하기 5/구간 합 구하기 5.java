import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] sums = new int[N][N]; // 누적합

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                
                if (j == 0) {
                    sums[i][j] = num;
                } else {
                    sums[i][j] = sums[i][j - 1] + num;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            
            int sum = 0;
            for (int i = x1; i <= x2; i++) {
                sum += sums[i][y2];
                if (y1 != 0) {
                    sum -= sums[i][y1 - 1];
                }
            }
            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }
}