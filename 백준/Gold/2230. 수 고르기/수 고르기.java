import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = -1;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] su = new int[N];

        for(int i=0; i<N; i++) {
            su[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(su); // 오름차순 정렬

        int front = 0, back = 1;

        if(M == 0) {
            result = 0;
        }
        else {
            while(front < N) {
                int cha = su[back] - su[front];

                if((result == -1 || cha < result) && cha >= M) {
                    result = cha;
                }

                if(back == N-1 || cha > M) { // 차이를 줄여봐야함. front를 뒤로 이동
                    front++;
                    if(front == back && back < N-1) back++;
                }
                else if(cha < M) { // 차이를 벌려야함. back을 뒤로 이동
                    back++;
                }
                else {
                    result = M;
                    break;
                }
            }
        }

        System.out.print(result);
    }
}