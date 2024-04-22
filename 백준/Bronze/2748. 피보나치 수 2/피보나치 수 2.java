import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long num1 = 1, num2 = 1;
        for(int i=3; i<=n; i++) {
            long temp = num2;
            num2 = num1 + num2;
            num1 = temp;
        }
        System.out.print(num2);
    }
}