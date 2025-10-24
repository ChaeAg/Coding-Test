import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sort_arr = Arrays.stream(arr).distinct().sorted().toArray();
        int sort_len = sort_arr.length - 1;

        for (int i = 0; i < N; i++) {
            int target = arr[i];

            int left = 0;
            int right = sort_len;

            while (left <= right) {
                int mid = (left + right) / 2;
                
                if (sort_arr[mid] == target) {
                    sb.append(mid).append(" ");
                    break;
                } 
                else if (sort_arr[mid] > target) right = mid - 1;
                else left = mid + 1;
            }
        }

        System.out.print(sb);
    }
}