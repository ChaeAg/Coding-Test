import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] room = new char[N][N];
        for(int i=0; i<N; i++) {
            room[i] = br.readLine().toCharArray();
        }

        int garo = 0, sero = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(room[i][j] == 'X') continue;
                if(j+1 < N && room[i][j+1] == '.') {
                    garo++;
                    while(j < N && room[i][j] == '.') {
                        j++;
                    }
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(room[j][i] == 'X') continue;
                if(j+1 < N && room[j+1][i] == '.') {
                    sero++;
                    while(j < N && room[j][i] == '.') {
                        j++;
                    }
                }
            }
        }

        System.out.print(garo + " " + sero);
    }
}