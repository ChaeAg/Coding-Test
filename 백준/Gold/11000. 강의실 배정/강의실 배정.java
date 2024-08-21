import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[][] time = new int[N][2];

            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                time[i][0] = Integer.parseInt(st.nextToken());
                time[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(time, (o1, o2) -> { // 시작시간 기준 오름차순 정렬
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1]; // 시작시간이 같으면 종료시간이 빠른 게 먼저 오게
                }
                return o1[0] - o2[0];
            });

            PriorityQueue<Integer> pq = new PriorityQueue<>(); // 종료시간 넣어주면 자동 오름차순 정렬
            pq.offer(time[0][1]);

            for (int i = 1; i < N; i++) {
                if (pq.peek() <= time[i][0]) { // 큐중에 가장 빠른 종료시간이 새로운 강의 시작시간보다 작거나 같냐 즉, 앞 강의가 강의실 빼주는거
                    pq.poll();
                }
                pq.offer(time[i][1]);
            }

            System.out.print(pq.size());
    }
}