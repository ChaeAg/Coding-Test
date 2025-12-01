import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        // [In 개수, Out 개수]를 저장하는 Map
        Map<Integer, int[]> nodeInfo = new HashMap<>();
        
        // 1. 모든 간선을 돌며 In/Out 차수 계산
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            
            // start 노드의 Out 증가 (인덱스 1)
            nodeInfo.putIfAbsent(start, new int[2]);
            nodeInfo.get(start)[1]++;
            
            // end 노드의 In 증가 (인덱스 0)
            nodeInfo.putIfAbsent(end, new int[2]);
            nodeInfo.get(end)[0]++;
        }
        
        int createdNode = 0;
        int barGraph = 0;
        int eightGraph = 0;
        
        // 2. 각 노드의 차수를 보며 그래프 종류 판별
        for (int key : nodeInfo.keySet()) {
            int[] count = nodeInfo.get(key);
            int in = count[0];
            int out = count[1];
            
            // 생성한 정점: 들어오는 건 없고(0), 나가는 건 2개 이상
            if (in == 0 && out >= 2) {
                createdNode = key;
            }
            // 막대 그래프: 나가는 게 없음(0) (들어오는 건 상관없으나 보통 1 이상)
            else if (out == 0) {
                barGraph++;
            }
            // 8자 그래프: 들어오는 거 2개 이상, 나가는 거 2개 (중심점)
            else if (in >= 2 && out == 2) {
                eightGraph++;
            }
        }
        
        // 3. 도넛 그래프 개수 계산
        // 생성 정점의 Out 개수 = 연결된 총 그래프 개수
        int totalGraphs = nodeInfo.get(createdNode)[1];
        int donutGraph = totalGraphs - barGraph - eightGraph;
        
        return new int[]{createdNode, donutGraph, barGraph, eightGraph};
    }
}