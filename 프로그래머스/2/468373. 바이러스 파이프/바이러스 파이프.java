import java.util.*;
class Solution {
    int maxInfection = 0;
    int k, n;
    /**
    * map 형태
    * 노드 번호 1 -> {노드 2, 파이프번호}
    */
    Map<Integer, List<int[]>> connect = new HashMap<>();
    public int solution(int n, int infection, int[][] edges, int k) {
        this.k = k;
        this.n = n;
        
        for(int[] edge : edges) {
            connect
                .computeIfAbsent(edge[0], a -> new ArrayList<>())
                .add(new int[]{edge[1], edge[2]});
            
            connect
                .computeIfAbsent(edge[1], a -> new ArrayList<>())
                .add(new int[]{edge[0], edge[2]});
        }
        
        Set<Integer> set = new HashSet<>();
        set.add(infection);
        dfs(0, set);
        
        return maxInfection;
    }
    
    void dfs(int openCnt, Set<Integer> infectionNodes) {
        if(openCnt == k) {
            return;
        }
        
        /**
        * 현재 시점에 감염된 노드들(infectionNodes)에 연결된 파이프는 전부 순회해보면서
        * 최대 감염할 수있는 노드 수를 구하는 방식
        */
        List<Set<Integer>> newInfections = new ArrayList<>();
        for(int i=0; i<=3; i++) {
            newInfections.add(new HashSet<>());
        }
        
        // que 구조
        // {pipe, 이 파이프로 인해 이번에 새로 감염된 노드}
        Queue<int[]> infectionQue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
            
        for(int node : infectionNodes) {
            infectionQue.add(new int[]{0, node});
            visited[node] = true;
        }
            
        while(!infectionQue.isEmpty()) {
            int[] arr = infectionQue.poll();
            int node = arr[1];
            int pipe = arr[0];
            List<int[]> connects = connect.get(node);
            if(connects == null) continue;
                
            for(int[] nodeAndPipe : connects) {
                int newNode = nodeAndPipe[0];
                int newPipe = nodeAndPipe[1];
                if(visited[newNode]
                   || pipe != 0 && pipe != newPipe) continue;
                
                infectionQue.add(new int[]{newPipe, newNode});
                newInfections.get(newPipe).add(newNode);
                visited[newNode] = true;
            }
        }
        
        for(Set<Integer> newInfection : newInfections) {
            if(newInfection.size() > 0) {
                infectionNodes.addAll(newInfection);
                maxInfection = Math.max(maxInfection, infectionNodes.size());
                dfs(openCnt+1, infectionNodes);
                infectionNodes.removeAll(newInfection);
            }
        }
    }
}