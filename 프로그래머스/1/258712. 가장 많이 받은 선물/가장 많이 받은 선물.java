import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        List<String> friendList = Arrays.asList(friends);
        // 다음 달에 각 사람이 선물 몇개를 받는지 저장
        Map<Integer, Integer> result = new HashMap();
        
        int len = friends.length;
        // 선물 게이지 계산을 위해 선물 준 수와 받은 수를 저장
        int[][] giftGauge = new int[len][2]; // {준 수, 받은 수}
        // 누가 누구에게 줬는지 기록
        int[][] event = new int[len][len];
        // 두 사람 간의 선물 계산 끝났으면 기록
        boolean[][] done = new boolean[len][len];
        
        for(String gift : gifts) {
            String[] frs = gift.split(" ");
            int giverIdx = friendList.indexOf(frs[0]); // 준 사람
            int reciverIdx = friendList.indexOf(frs[1]); // 받은 사람
            
            event[reciverIdx][giverIdx]++; // 누가누구에게 줬는지 기록
            
            giftGauge[giverIdx][0]++; // 0: 준 수 증가
            giftGauge[reciverIdx][1]++; // 1: 받은 수 증가
        }
        
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                if(done[i][j]) { // 두 사람 간 계산 이미 상대편이 했으면 건너뛰기
                    continue;
                }
                
                if(event[i][j] != event[j][i]) { // 누군가가 더 많이 줌
                    if(event[i][j] > event[j][i]) { // j 인덱스가 더 많이 줌
                        result.put(j, result.getOrDefault(j, 0)+1);
                    }
                    else { // i 인덱스가 더 많이 줌
                        result.put(i, result.getOrDefault(i, 0)+1);
                    }
                }
                else { // 준 수가 똑같거나, 둘 다 안줌 -> 선물 게이지 비교
                    int gauge1 = giftGauge[i][0] - giftGauge[i][1];
                    int gauge2 = giftGauge[j][0] - giftGauge[j][1];
                    
                    if(gauge1 < gauge2) { // j 인덱스가 게이지 더 높음
                        result.put(j, result.getOrDefault(j, 0)+1);
                    }
                    else if(gauge1 > gauge2) { // i 인덱스가 게이지 더 높음
                        result.put(i, result.getOrDefault(i, 0)+1);
                    }
                }
                // 두사람 간 계산 끝났다고 기록
                done[i][j] = true;
                done[j][i] = true;
            }
        }
        // 다음 달에 아무도 선물을 안받는 경우가 있음
        if(result.size() == 0) answer = 0;
        else answer = Collections.max(result.values());
        
        return answer;
    }
}