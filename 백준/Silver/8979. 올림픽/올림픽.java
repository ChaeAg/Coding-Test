import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] scores = new int[N][4];
        for(int i=0; i<N; i++) {
            scores[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        Arrays.sort(scores, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                if(o1[2] == o2[2]) {
                    return o2[3] - o1[3];
                }
                return o2[1] - o1[2];
            }
            return o2[1] - o1[1];
        });

        int grade = 0;
        int gauge = 1;
        for(int i=0; i<N; i++) {
            if(i == N-1) {
                grade += gauge;
                break;
            }
            if(i != 0 && scores[i][1] == scores[i-1][1] && scores[i][2] == scores[i-1][2] && scores[i][3] == scores[i-1][3]) {
                gauge++;
            }
            else {
                grade += gauge;
                gauge = 1;
            }
            if(scores[i][0] == K) {
                break;
            }
        }

        System.out.print(grade);
    }
}