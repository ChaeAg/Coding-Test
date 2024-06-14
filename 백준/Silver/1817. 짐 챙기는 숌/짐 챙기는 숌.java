import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(N == 0) {
            System.out.print(0);
        }
        else {
            int[] weights = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int sum = 0, box = 0;

            for(int weight : weights) {
                if(sum + weight > M) {
                    box++;
                    sum = 0;
                }
                sum += weight;
            }

            System.out.print(sum == 0 ? box : box+1);
        }
    }
}