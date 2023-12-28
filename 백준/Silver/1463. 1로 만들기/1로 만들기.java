import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N+1]; // N 인덱스에 정수 N이 되는 연산의 최솟값이 들어갈 것이기 때문에 N+1로 선언
        
        // 2부터 시작하는 이유? -> 정수 0과 1은 {1을 만드는 연산} 경우의 수가 0이기 때문
        for(int i=2; i<d.length; i++) {
            // 1을 더해서 만들 수 있는 경우
            d[i] = d[i-1] + 1;
            
            // 2로 나눠지면 2를 곱해서 만들 수 있는 경우임
            // ex) i = 4, d[4] = Math.min(d[4], d[2]+1) -> 결과: d[4] = 2
            if(i % 2 == 0) {
                d[i] = Math.min(d[i], d[i/2] + 1); // 1을 더해서 만드는 거랑 2를 곱해서 만드는 거 중에 횟수가 적은 것을 택함
            }
            
            // 3으로 나눠지면 3을 곱해서 만들 수 있는 경우임
            // ex) i = 6, d[6] = Math.min(d[6], d[2]+1) -> 결과: d[6] = 2
            if(i % 3 == 0) {
                d[i] = Math.min(d[i], d[i/3] + 1); // 1을 더해서 만드는 거랑 3를 곱해서 만드는 거 중에 횟수가 적은 것을 택함
            }
        }
        System.out.print(d[N]);
    }
}