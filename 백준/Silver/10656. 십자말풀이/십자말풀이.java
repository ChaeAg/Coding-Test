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

        String[][] puzzle = new String[N][M];

        for(int i=0; i<N; i++) {
            puzzle[i] = br.readLine().split("");
        }

        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(puzzle[i][j].equals("#")) continue;

                if(((j-1 < 0 || puzzle[i][j-1].equals("#")) && j+2 < M && puzzle[i][j+1].equals(".") && puzzle[i][j+2].equals(".")) ||
                        ((i-1 < 0 || puzzle[i-1][j].equals("#")) && i+2 < N && puzzle[i+1][j].equals(".") && puzzle[i+2][j].equals("."))) {
                    count++;
                    sb.append(i+1).append(" ").append(j+1).append("\n");
                }
            }
        }

        System.out.println(count);
        System.out.print(sb);
    }
}