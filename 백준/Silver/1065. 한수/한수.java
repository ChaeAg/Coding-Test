import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 99;

        if(N < 99) sum = N; // N이 99보다 작으면 자기 자신만큼 한수가 존재
        else {
            for(int i=111; i<=N; i++) {
                String num = String.valueOf(i);
                int n1 = Integer.parseInt(num.substring(0,1));
                int n2 = Integer.parseInt(num.substring(1,2));
                int n3 = Integer.parseInt(num.substring(2));
                if(n1 - n2 == n2 - n3) sum++;
            }
        }

        System.out.print(sum);
    }
}