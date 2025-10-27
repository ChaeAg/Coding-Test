import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];

            for (int i = 0; i < N; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            Arrays.sort(arr, Comparator.comparingInt(o -> o[0])); // 서류심사등수 오름차순 (1등부터)

            int cnt = 1; // 서류심사 1등은 무조건 합격이니까
            int max_j = arr[0][1]; // 서류심사 1등의 면접 등수
            for (int i = 1; i < N; i++) { // 서류심사 2~N등까지 합격자 중, 자신보다 서류 심사 등수가 높은 사람보다 면접등수가 높다면 합격, 면접등수 MAX 갱신
                if (arr[i][1] < max_j) {
                    cnt++;
                    max_j = arr[i][1];
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}