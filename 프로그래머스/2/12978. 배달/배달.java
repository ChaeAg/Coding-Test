import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<int[]>[] graph = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) { // 인접 리스트 생성
            graph[i] = new ArrayList<>();
        }
        for (int[] r : road) { // 두 노드 연결
            graph[r[0]].add(new int[]{r[1], r[2]});
            graph[r[1]].add(new int[]{r[0], r[2]});
        }

        int[] min_money = new int[N + 1];
        Arrays.fill(min_money, Integer.MAX_VALUE);
        min_money[1] = 0; // 1은 시작점이기 때문에 0의 비용으로 간다.
        
        // queue ([노드로 가는데 드는 비용, 노드 번호], ...) , 비용이 적을수록 우선순위를 가진다.
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        pq.add(new int[]{0, 1});

        while (!pq.isEmpty()) { // 모든 노드를 다 돌 때까지
            int[] arr = pq.poll();
            for (int[] nodes : graph[arr[1]]) { // 이번 노드에 연결된 노드들 순회
                if (min_money[nodes[0]] > arr[0] + nodes[1]) {
                    min_money[nodes[0]] = Math.min(min_money[nodes[0]], arr[0] + nodes[1]);
                    pq.offer(new int[]{min_money[nodes[0]], nodes[0]});
                }
            }
        }

        for (int i : min_money) {
            if (i <= K) {
                answer++;
            }
        }

        return answer;
    }
}