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
        String[][] floor = new String[N][M];

        for(int i=0; i<N; i++) {
            floor[i] = br.readLine().split("");
        }

        int stack, wood = 0;

        for(int i=0; i<N; i++) { // 행 우선 탐색
            stack = 0;
            for(int j=0; j<M; j++) {
                if(floor[i][j].equals("-")) stack++;
                else if(stack != 0) {
                    wood++;
                    stack = 0;
                }
            }
            if(stack != 0) wood++; // 행 마지막 거에도 판자가 필요했을 때
        }

        for(int i=0; i<M; i++) { // 열 우선 탐색
            stack = 0;
            for(int j=0; j<N; j++) {
                if(floor[j][i].equals("|")) stack++;
                else if(stack != 0) {
                    wood++;
                    stack = 0;
                }
            }
            if(stack != 0) wood++;
        }

        System.out.print(wood);
    }
}