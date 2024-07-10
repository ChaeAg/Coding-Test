import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북, 동, 남, 서 순서

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int see = Integer.parseInt(st.nextToken());

        String[][] room = new String[N][M];

        for(int i=0; i<N; i++) {
            room[i] = br.readLine().split(" ");
        }

        int count = 0;

        while(true) {
            if(room[r][c].equals("0")) {
                room[r][c] = "2"; // 청소한 곳
                count++;
            }
            boolean clean = true;

            for(int i=0; i<4; i++) {
                see = (see + 3) % 4;
                int next_r = r + move[see][0];
                int next_c = c + move[see][1];

                if(room[next_r][next_c].equals("0")) {
                    r = next_r;
                    c = next_c;
                    clean = false;
                    break;
                }
            }

            if(clean) {
                // 후진
                int next_r = r - move[see][0];
                int next_c = c - move[see][1];

                if(room[next_r][next_c].equals("1")) break; // 후진했을 때 벽이라면 while 탈출

                r = next_r;
                c = next_c;
            }
        }

        System.out.print(count);
    }
}