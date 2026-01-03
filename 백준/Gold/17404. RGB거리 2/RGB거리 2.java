import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] map = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp_0 = new int[N][3];
        int[][] dp_1 = new int[N][3];
        int[][] dp_2 = new int[N][3];

        dp_0[0][0] = map[0][0];
        dp_0[0][1] = 1001;
        dp_0[0][2] = 1001;

        dp_1[0][1] = map[0][1];
        dp_1[0][0] = 1001;
        dp_1[0][2] = 1001;

        dp_2[0][2] = map[0][2];
        dp_2[0][0] = 1001;
        dp_2[0][1] = 1001;

        for (int i = 1; i < N; i++) {
            if (i == N - 1) {
                dp_0[i][1] = map[i][1] + Math.min(dp_0[i - 1][0], dp_0[i - 1][2]);
                dp_0[i][2] = map[i][2] + Math.min(dp_0[i - 1][0], dp_0[i - 1][1]);

                dp_1[i][0] = map[i][0] + Math.min(dp_1[i - 1][1], dp_1[i - 1][2]);
                dp_1[i][2] = map[i][2] + Math.min(dp_1[i - 1][0], dp_1[i - 1][1]);

                dp_2[i][0] = map[i][0] + Math.min(dp_2[i - 1][1], dp_2[i - 1][2]);
                dp_2[i][1] = map[i][1] + Math.min(dp_2[i - 1][0], dp_2[i - 1][2]);

                break;
            }

            dp_0[i][0] = map[i][0] + Math.min(dp_0[i - 1][1], dp_0[i - 1][2]);
            dp_0[i][1] = map[i][1] + Math.min(dp_0[i - 1][0], dp_0[i - 1][2]);
            dp_0[i][2] = map[i][2] + Math.min(dp_0[i - 1][0], dp_0[i - 1][1]);

            dp_1[i][0] = map[i][0] + Math.min(dp_1[i - 1][1], dp_1[i - 1][2]);
            dp_1[i][1] = map[i][1] + Math.min(dp_1[i - 1][0], dp_1[i - 1][2]);
            dp_1[i][2] = map[i][2] + Math.min(dp_1[i - 1][0], dp_1[i - 1][1]);

            dp_2[i][0] = map[i][0] + Math.min(dp_2[i - 1][1], dp_2[i - 1][2]);
            dp_2[i][1] = map[i][1] + Math.min(dp_2[i - 1][0], dp_2[i - 1][2]);
            dp_2[i][2] = map[i][2] + Math.min(dp_2[i - 1][0], dp_2[i - 1][1]);
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            if (dp_0[N - 1][i] == 0) {
                min = Math.min(min, Math.min(dp_1[N - 1][i], dp_2[N - 1][i]));
            }
            if (dp_1[N - 1][i] == 0) {
                min = Math.min(min, Math.min(dp_0[N - 1][i], dp_2[N - 1][i]));
            }
            if (dp_2[N - 1][i] == 0) {
                min = Math.min(min, Math.min(dp_0[N - 1][i], dp_1[N - 1][i]));
            }
        }

        System.out.print(min);
    }
}