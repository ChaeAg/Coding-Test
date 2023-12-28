import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int num : Arrays.stream(br.readLine().split(" "))
            .distinct()
            .mapToInt(Integer::parseInt)
            .sorted().toArray()) {
            sb.append(num).append(" ");
        }
        System.out.print(sb);
    }
}