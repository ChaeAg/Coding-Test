import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 0;
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long[] course = new long[N];
        long sum = 0;
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            course[i] = Long.parseLong(st.nextToken());
            sum += course[i];
        }

        if(K < sum) { // 끝까지 가는 중
            long nujuck = 0;
            for(int i=0; i<N; i++) {
                nujuck += course[i];
                if(nujuck > K) {
                    answer = i + 1;
                    break;
                }
            }
        }
        else if(K > sum) { // 끝까지 갔다가 돌아오는 중
            long nujuck = sum;
            for(int i=N-1; i>=0; i--) {
                nujuck += course[i];
                if(nujuck > K) {
                    answer = i+1;
                    break;
                }
            }
        }
        else { // 끝에 있을 경우
            answer = N;
        }

        System.out.print(answer);
    }
}