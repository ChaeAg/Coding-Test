import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int N = Integer.parseInt(br.readLine());
                if(Integer.toString(N, 3).contains("2") || N == 0) System.out.println("NO");
                else System.out.println("YES");
        }
}