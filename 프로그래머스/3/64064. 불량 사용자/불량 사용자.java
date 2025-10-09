import java.util.*;
import java.util.stream.*;
class Solution {
    static Map<Integer, List<Integer>> map = new HashMap<>();
    // map 구조: Map<banned_id 인덱스, 해당 banned_id에 매핑된 user_id 인덱스>
    static Set<String> answer_set = new HashSet<>();
    static int banned_id_count;
    public int solution(String[] user_id, String[] banned_id) {
        banned_id_count = banned_id.length;
        for(int i=0; i<banned_id_count; i++) {
            String banned_id_str = banned_id[i];
            for(int j=0; j<user_id.length; j++) {
                String user_id_str = user_id[j];
                if(banned_id_str.length() != user_id_str.length()) continue;
                
                boolean isSame = true;
                for(int k=0; k<banned_id_str.length(); k++) {
                    if(banned_id_str.charAt(k) != '*' && banned_id_str.charAt(k) != user_id_str.charAt(k)) {
                        isSame = false;
                        break;
                    }
                }
                if(isSame) { // 제재 아이디에 매핑이 됨.
                    List<Integer> temp = map.getOrDefault(i, new ArrayList<>());
                    temp.add(j);
                    map.put(i, temp);
                }
            }
        }
        
        dfs(0, new ArrayList<>());
            
        return answer_set.size();
    }
    
    public void dfs(int dept, List<Integer> result_basket) {
        if(dept == map.size()) {
            if(result_basket.size() == banned_id_count) { // 모든 밴 아이디에 매칭 되었다면
                Collections.sort(result_basket); // 중복 경우의 수 제거를 위함
                answer_set.add(result_basket.stream().map(String::valueOf).collect(Collectors.joining(", ")));
                return;
            }
        }
        
        List<Integer> mapping_user_ids = map.get(dept);
        
        for(int i=0; i<mapping_user_ids.size(); i++) {
            int mapping_user_id = mapping_user_ids.get(i);
            if(result_basket.contains(mapping_user_id)) continue; // 이미 앞 밴 규칙에 쓴 아이디라면 패스
            
            result_basket.add(mapping_user_id);
            dfs(dept+1, result_basket);
            result_basket.remove(Integer.valueOf(mapping_user_id));
        }
    }
}