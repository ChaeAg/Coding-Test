import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> answer = new ArrayList();
        Map<String, Integer> memory = new HashMap();
        
        for(int i=0; i<name.length; i++) {
            memory.put(name[i], yearning[i]);
        }
        
        for(int i=0; i<photo.length; i++) {
            int sum = 0;
            for(int j=0; j<photo[i].length; j++) {
                sum += memory.getOrDefault(photo[i][j], 0);
            }
            answer.add(sum);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}