import java.util.*;
class Solution {
    static List<String[]> answer = new ArrayList<>();
    static int len;
    static Map<String, List<String>> map = new HashMap<>();
    public String[] solution(String[][] tickets) {
        len = tickets.length;
        List<List<String>> list = new ArrayList<>();
        
        for(String[] ticket : tickets) {
            List<String> temp = map.getOrDefault(ticket[0], new ArrayList<>());
            temp.add(ticket[1]);
            map.put(ticket[0], temp);
                
            list.add(List.of(ticket[0], ticket[1]));
        }
        
        String[] path = new String[len+1];
        path[0] = "ICN";
        dfs("ICN", 1, path, list);
        
        // TODO: 알파벳순 정렬
        Collections.sort(answer, (a, b) -> {
            int l = a.length-1;
            for(int i=0; i<=l; i++) {
                int cmp = a[i].compareTo(b[i]);
                if(cmp != 0) {
                    return a[i].compareTo(b[i]);
                }
            }
            return a[l].compareTo(b[l]);
        });
        
        return answer.get(0);
    }
    
    static void dfs(String airport_name, int depth, String[] path, List<List<String>> list) {
        if(depth == len) {
            path[depth] = list.get(0).get(1);
            answer.add(path.clone());
            return;
        }
        
        List<String> connect = map.get(airport_name);
        
        if(connect == null || connect.isEmpty()) return;
        
        for(String s : connect) {
            List<String> pair = List.of(airport_name, s);
            int idx = list.indexOf(pair);
            
            // 이미 사용한 티켓인가?
            if(idx == -1) continue;
            
            path[depth] = s;
            list.remove(idx);
            
            dfs(s, depth+1, path, list);
                
            path[depth] = null;
            list.add(pair);
        }
    }
}