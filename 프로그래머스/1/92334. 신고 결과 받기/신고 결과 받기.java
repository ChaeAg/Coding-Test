import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        List<String> ids = Arrays.asList(id_list);
        Map<String, Integer> reportedCount = new HashMap();
        List<String> dangerUsers = new ArrayList();
        boolean[][] result = new boolean[id_list.length][id_list.length];
        
        for(String rp : report) {
            String[] users = rp.split(" ");
            String reported = users[1];
            int idx1 = ids.indexOf(users[0]);
            int idx2 = ids.indexOf(reported);
            
            if(!result[idx2][idx1]) {
                reportedCount.put(reported, reportedCount.getOrDefault(reported, 0)+1);
                result[idx2][idx1] = true;
            }
            
            if(!dangerUsers.contains(reported) && reportedCount.get(reported) >= k) {
                dangerUsers.add(reported);
            }
        }
        
        for(String dangerUser : dangerUsers) {
            int idx = ids.indexOf(dangerUser);
            for(int i=0; i<result[idx].length; i++) {
                if(result[idx][i]) answer[i]++;
            }
        }
        
        return answer;
    }
}