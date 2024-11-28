import java.util.*;

class Solution {
    static boolean[] visited;
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static int answer = 100, cnt = 0;
    
    public int solution(int n, int[][] wires) {
        int answer = 100;
        
        for(int i=0; i<n-1; i++) {
            List<Integer> list = map.getOrDefault(wires[i][0], new ArrayList<>());
            list.add(wires[i][1]);
            map.put(wires[i][0], list);

            list = map.getOrDefault(wires[i][1], new ArrayList<>());
            list.add(wires[i][0]);
            map.put(wires[i][1], list);
        }

        for(int i=0; i<n-1; i++) {
            // 연결선 하나씩 다 끊어보기
            List<Integer> list = map.get(wires[i][0]);
            list.remove((Integer) wires[i][1]);
            map.replace(wires[i][0], list);

            list = map.get(wires[i][1]);
            list.remove((Integer) wires[i][0]);
            map.replace(wires[i][1], list);

            // dfs 진행
            // 분리된 두 트리 중 첫번째 트리 순회
            visited = new boolean[n+1];
            dfs(wires[i][0]);
            int count1 = cnt;

            cnt = 0;
            visited = new boolean[n+1];

            // 분리된 두 트리 중 두번째 트리 순회
            dfs(wires[i][1]);
            int count2 = cnt;

            cnt = 0;

            answer = Math.min(answer, Math.abs(count1 - count2));

            // 다시 연결
            list = map.getOrDefault(wires[i][0], new ArrayList<>());
            list.add(wires[i][1]);
            map.put(wires[i][0], list);

            list = map.getOrDefault(wires[i][1], new ArrayList<>());
            list.add(wires[i][0]);
            map.put(wires[i][1], list);
        }

        return answer;
    }
    
    void dfs(int node) {
        visited[node] = true;

        for(int n : map.get(node)) {
            if(!visited[n]) {
                cnt++;
                dfs(n);
            }
        }
    }
}