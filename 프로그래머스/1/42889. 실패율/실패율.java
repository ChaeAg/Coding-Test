import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Arrays.sort(stages);
        Map<Integer, Float> failRate = new LinkedHashMap<>();
        for(int i=1; i<=N; i++) {
            float same = 0.0f;
            float dodal = 0.0f;
            for(int j=0; j<stages.length; j++) {
                if(stages[j] == i) {
                    dodal++;
                    same++;
                }
                else if(stages[j] > i) dodal++;
            }
            if(same != 0 || dodal != 0) failRate.put(i, same/dodal);
            else failRate.put(i, 0.0f);
        }
        List<Integer> keys = new ArrayList<>(failRate.keySet());
        for(int key : keys) {
            System.out.println(key + " " + failRate.get(key));
        }
		Collections.sort(keys, (v1, v2) -> (failRate.get(v2).compareTo(failRate.get(v1))));
        int idx = 0;
        for(int key : keys) {
            answer[idx++] = key;
        }
        for(int i=1; i<=N; i++) {
            if(!keys.contains(i)) {
                answer[idx++] = i;
            }
        }
        
        return answer;
    }
}