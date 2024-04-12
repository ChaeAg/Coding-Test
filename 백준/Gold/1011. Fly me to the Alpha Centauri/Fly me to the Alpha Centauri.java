import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            String[] inputs = br.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);
            int cha = y - x;
            int count;
            long max = Math.round(Math.sqrt(cha));
            if(cha > Math.pow(max, 2)) count = (int)max * 2;
            else count = (int)max * 2 - 1;

            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}