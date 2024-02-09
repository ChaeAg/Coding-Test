import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inputs = br.readLine().split(" ");
        int M = Integer.parseInt(inputs[0]);
        int N = Integer.parseInt(inputs[1]);

        for(int i=M; i<=N; i++) {
            if(i == 1) continue;
            if(isSosu(i))
                sb.append(i).append("\n");
        }

        System.out.print(sb);
    }

    public static boolean isSosu(int num) {
        for(int i=2; i*i<=num; i++) {
            if(num % i == 0) return false;
        }

        return true;
    }
}