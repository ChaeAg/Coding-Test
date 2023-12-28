import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] d = new int[n+1];
            if(n == 1) {
                sb.append(1).append("\n");
                continue;
            }
            else if(n == 2) {
                sb.append(2).append("\n");
                continue;
            }
            else if(n == 3) {
                sb.append(4).append("\n");
                continue;
            }
            d[1] = 1; // 1
            d[2] = 2; // 1+1, 2
            d[3] = 4; // 1+1+1, 1+2, 2+1, 3
            for(int j=4; j<d.length; j++){
                // 1을 더해서 만들 수 있는 경우, 2를 더해서 만들 수 있는 경우, 3을 더해서 만들 수 있는 경우를 모두 더함
                d[j] = d[j-1] + d[j-2] + d[j-3];
            }
            sb.append(d[n]).append("\n");
        }
        System.out.print(sb);
    }
}