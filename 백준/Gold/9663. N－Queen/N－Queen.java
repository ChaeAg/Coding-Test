import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] map;
    static int result = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];

        dfs(0);

        System.out.print(result);
    }

    static void dfs(int row) {
        if (row == N) {
            result++;
            return;
        }

        for (int c = 0; c < N; c++) {
            boolean isOk = true;
            for (int i = 0; i < row; i++) {
                // 같은 열에 퀸이 있는지 확인
                if (map[i] == c || Math.abs(map[i] - c) == Math.abs(i - row)) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                map[row] = c;
                dfs(row + 1);
            }
        }
    }
}