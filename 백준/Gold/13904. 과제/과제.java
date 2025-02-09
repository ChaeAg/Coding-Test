import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> task_queue = new PriorityQueue<>((o1, o2) -> { // 점수가 높은 순
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });

        for (int i = 0; i < N; i++) {
            task_queue.add(Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray());
        }

        int max_score = 0;
        int[] score = new int[1001];

        while (!task_queue.isEmpty()) {
            int[] task = task_queue.poll();

            for (int i = task[0]; i > 0; i--) {
                if (score[i] == 0) {
                    score[i] = task[1];
                    max_score += task[1];
                    break;
                }
            }
        }

        System.out.print(max_score);
    }
}