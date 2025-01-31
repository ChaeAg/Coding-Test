import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] bridge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int s = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[s - 1] = true;
        q.add(s - 1);

        int count = 1;

        while (!q.isEmpty()) {
            int now_idx = q.poll();
            int d = bridge[now_idx]; // 이동할 수 있는 거리
            int next;
            if (now_idx - d >= 0) { // 왼쪽으로 점프
                next = now_idx - d;
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    count++;
                }
            }
            if (now_idx + d < n) { // 오른쪽으로 점프
                next = now_idx + d;
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    count++;
                }
            }
        }

        System.out.print(count);
    }
}