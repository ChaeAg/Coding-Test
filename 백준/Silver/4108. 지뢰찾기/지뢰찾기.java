import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String[] RandC = br.readLine().split(" ");
            if(RandC[0].equals("0") && RandC[1].equals("0")) break;
            int R = Integer.parseInt(RandC[0]);
            int C = Integer.parseInt(RandC[1]);
            String[][] puzzle = new String[R][C];
            for(int i=0; i<R; i++) {
                puzzle[i] = br.readLine().split("");
            }
            int[][] result = new int[R][C];
            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {
                    if(puzzle[i][j].equals("*")) {
                        if(j+1 < C) { // 오
                            result[i][j+1]++;
                            if(i-1 >= 0) result[i-1][j+1]++; // 오+위
                            if(i+1 < R) result[i+1][j+1]++; // 오+아래
                        }
                        if(j-1 >= 0) { // 왼
                            result[i][j-1]++;
                            if(i-1 >= 0) result[i-1][j-1]++; // 왼+위
                            if(i+1 < R) result[i+1][j-1]++; // 왼+아래
                        }
                        if(i+1 < R) result[i+1][j]++; // 아래
                        if(i-1 >= 0) result[i-1][j]++; // 위
                    }
                }
            }
            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {
                    if(puzzle[i][j].equals("*")) {
                        sb.append("*");
                        continue;
                    }
                    sb.append(result[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}