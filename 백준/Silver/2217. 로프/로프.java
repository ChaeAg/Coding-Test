import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] rope = new int[N];
        for(int i=0; i<N; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope); // 오름차순 정렬
        int maxWeight = 0;
        for(int i=N-1; i>=0; i--) {
            if(maxWeight < rope[i] * (N-i)) {
                maxWeight = rope[i] * (N-i);
            }
        }
        System.out.print(maxWeight);
    }
}