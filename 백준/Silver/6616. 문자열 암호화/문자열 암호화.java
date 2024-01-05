import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            String[] arr = br.readLine().replace(" ", "").split("");
            String[] result = new String[arr.length];
            int startIdx = 0;
            int idx = startIdx;
            int arrIdx = 0;
            while(arrIdx < arr.length) {
                result[idx] = arr[arrIdx++];
                if(idx + N > arr.length - 1) {
                    startIdx++;
                    idx = startIdx;
                }
                else {
                    idx += N;
                }
            }
            sb.append(String.join("", result).toUpperCase()).append("\n");
        }
        System.out.print(sb);
    }
}