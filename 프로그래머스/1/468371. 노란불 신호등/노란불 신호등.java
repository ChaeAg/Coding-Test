import java.util.*;

class Solution {
    long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    
    public int solution(int[][] signals) {
        int answer = -1;
        int signalCnt = signals.length;
        
        // {기다리는 시간, 유지 시간}
        int[][] data = new int[signalCnt][2];
        for(int i=0; i<signalCnt; i++) {
            data[i][0] = signals[i][0] + signals[i][2] + 1;
            data[i][1] = signals[i][1] - 1;
        }
        
        // LCM 계산 (탐색 범위 제한용)
        long lcm = 1;
        for(int[] signal : signals) {
            long period = signal[0] + signal[1] + signal[2];
            lcm = lcm * period / gcd(lcm, period);
        }
        
        // {신호등 인덱스, 가장 최근 노란불 끝난 시간}
        Queue<int[]> que = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<signalCnt; i++) {
            int time = signals[i][0];
            for(int t=0; t<=data[i][1]; t++) {
                time++;
                map.put(time, map.getOrDefault(time, 0) + 1);
                if(map.get(time) == signalCnt) {
                    return time;
                }
            }
            que.add(new int[]{i, time});
        }
        
        while(answer == -1 && !que.isEmpty()) {
            int[] now = que.poll();
            int idx = now[0];
            int time = now[1];
            
            time += data[idx][0] - 1;
            
            if(time > lcm) break;
            
            for(int t=0; t<=data[idx][1]; t++) {
                time++;
                map.put(time, map.getOrDefault(time, 0) + 1);
                if(map.get(time) == signalCnt) {
                    answer = time;
                    break;
                }
            }
                
            que.add(new int[]{idx, time});
        }
        
        return answer;
    }
}