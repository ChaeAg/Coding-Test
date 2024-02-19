import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        int M = Integer.parseInt(br.readLine());

        for(String s : br.readLine().split(" ")) {
            sb.append(binarySearch(Integer.parseInt(s), 0, N-1)).append("\n");
        }

        System.out.print(sb);
    }

    static String binarySearch(int key, int low, int high) {
        int mid;

        while(low <= high) {
            mid = (low + high) / 2;
            if(A[mid] == key) {
                return "1";
            }
            else if(A[mid] > key) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return "0";
    }
}