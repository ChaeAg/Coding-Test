import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 0; k < 3; k++) {
                map[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] maxDp = new int[N][3];
        maxDp[0][0] = map[0][0];
        maxDp[0][1] = map[0][1];
        maxDp[0][2] = map[0][2];
        int[][] minDp = new int[N][3];
        minDp[0][0] = map[0][0];
        minDp[0][1] = map[0][1];
        minDp[0][2] = map[0][2];

        for (int i = 1; i < N; i++) {
            maxDp[i][0] = Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + map[i][0];
            maxDp[i][1] = Math.max(maxDp[i - 1][2], Math.max(maxDp[i - 1][0], maxDp[i - 1][1])) + map[i][1];
            maxDp[i][2] = Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + map[i][2];

            minDp[i][0] = Math.min(minDp[i - 1][0], minDp[i - 1][1]) + map[i][0];
            minDp[i][1] = Math.min(minDp[i - 1][2], Math.min(minDp[i - 1][0], minDp[i - 1][1])) + map[i][1];
            minDp[i][2] = Math.min(minDp[i - 1][1], minDp[i - 1][2]) + map[i][2];
        }

        int max = Math.max(maxDp[N - 1][2], Math.max(maxDp[N - 1][0], maxDp[N - 1][1]));
        int min = Math.min(minDp[N - 1][2], Math.min(minDp[N - 1][0], minDp[N - 1][1]));

        System.out.print(max + " " + min);
    }
}