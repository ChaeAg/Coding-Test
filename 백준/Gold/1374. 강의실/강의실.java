import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] lessons = new int[N][3];

        for (int i = 0; i < N; i++) {
            lessons[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Arrays.sort(lessons, (o1, o2) -> { // 배열은 시작시간이 빠른 순으로 정렬
            if (o1[1] == o2[1]) {
                return o1[2] - o2[2];
            }
            return o1[1] - o2[1];
        });

        PriorityQueue<int[]> q = new PriorityQueue<>(((o1, o2) -> { // 큐는 종료시간이 빠른 순으로 정렬되도록
            if (o1[2] == o2[2]) {
                return o1[1] - o2[1];
            }
            return o1[2] - o2[2];
        }));

        int result = 1;

        for (int i = 0; i < N; i++) {
            if (q.isEmpty()) {
                q.add(lessons[i]);
                continue;
            }
            int[] lesson = q.poll();
            if (lesson[2] > lessons[i][1]) { // 빈 강의실 없음
                q.add(lesson);
                result++;
            }
            q.add(lessons[i]);
        }

        System.out.print(result);
    }
}