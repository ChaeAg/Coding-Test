import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        Set<Integer> memory = new HashSet<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 이빨 자국 위치
            memory.add(arr[i]);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= N / 2; i++) { // 송곳니 간격 인덱스 version (1부터 2, 3, 4, ... N/2까지 가능함)
            int distance = arr[i] - arr[0]; // 간격 구하기
            boolean is_ok = true;

            for (int k = 0; k < N; k++) {
                if (!(memory.contains(arr[k] - distance) || memory.contains(arr[k] + distance))) {
                    is_ok = false;
                    break;
                }
            }

            if (is_ok) {
                result.add(distance);
            }
        }

        sb.append(result.size()).append("\n");

        for (int i : result) {
            sb.append(i).append(" ");
        }

        System.out.print(sb);
    }
}