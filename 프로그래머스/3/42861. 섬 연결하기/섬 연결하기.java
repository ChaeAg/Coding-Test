import java.util.*;
class Solution {
    public void union(int[] parent, int x, int y) {
        x = find(parent, x);
        y = find(parent, y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    public int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return find(parent, parent[x]);
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        // 부모노드 초기화
        int[] parent = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        // 크루스칼 알고리즘
        for (int i = 0; i < costs.length; i++) {
            // 부모가 같지 않으면. 즉, 사이클이 생기지 않으면 간선 선택
            if (find(parent, costs[i][0]) != find(parent, costs[i][1])) {
                answer += costs[i][2];
                union(parent, costs[i][0], costs[i][1]);
            }
        }
        
        return answer;
    }
}