import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        Arrays.sort(jobs, ((o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        })); // 작업 시작 시간이 빠른 순, 소요 시간이 빠른 순으로 정렬

        PriorityQueue<int[]> q = new PriorityQueue<>(((o1, o2) -> {
            if (o1[1] == o2[1]) {
                if (o1[0] == o2[0]) {
                    return 0;
                }
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        }));

        int done_count = jobs.length, idx = 0, time = 0;

        while (done_count > 0) {
            if (q.isEmpty()) { // 큐가 비었으면 (작업할게 없으면) 시간을 뒤로 보내서 젤 먼저 시작할 수 있는 작업 대기 큐에 넣기
                time = jobs[idx][0];
                q.add(jobs[idx++]);
                continue;
            }
            int[] arr = q.poll(); // 대기 큐에서 제일 우선순위가 높은 작업 꺼내기
            time += arr[1]; // 지금 시간에 현재 작업 소요 시간 더하기 == 끝나는 시간
            answer += (time - arr[0]); // 이 작업이 들어온 시간과 작업이 끝난 지금 시간의 차 구하기 (평균 구하기 용)
            done_count--;

            while (true) { // 현재 시간에 작업 시작할 수 있는 작업들 대기 큐에 넣음
                if (idx >= jobs.length || time < jobs[idx][0]) {
                    break;
                }

                q.add(jobs[idx++]);
            }
        }
        
        return answer / jobs.length;
    }
}