import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        int M = Integer.parseInt(br.readLine());
        for(String s : br.readLine().split(" ")) {
           sb.append(binarySearch(Integer.parseInt(s), 0, N-1)).append(" ");
        }
        System.out.print(sb);
    }

    static String binarySearch(int key, int low, int high) {
        int mid;

        while(low <= high) {
            mid = (low + high) / 2;
            if(numbers[mid] == key) {
                return "1";
            }
            else if(numbers[mid] < key) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return "0";
    }
}