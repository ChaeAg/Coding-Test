import java.util.*;
class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    List<List<String>> results = new ArrayList<>();
    boolean[] used;
    int resultSize;
    String[][] tickets;
    
    public String[] solution(String[][] tickets) {
        resultSize = tickets.length + 1;
        this.tickets = tickets;
        used = new boolean[tickets.length];
        
        for(int i=0; i<tickets.length; i++) {
            map.computeIfAbsent(tickets[i][0], k -> new ArrayList<>()).add(i);
        }
        
        List<String> tmp = new ArrayList<>();
        tmp.add("ICN");
        dfs("ICN", tmp);
        
        Collections.sort(results, (o1, o2) -> {
            for(int i=0; i<o1.size(); i++) {
                if(o1.get(i).equals(o2.get(i))) continue;
                return o1.get(i).compareTo(o2.get(i));
            }
            return 0;
        });
        
        return results.get(0).toArray(new String[resultSize]);
    }
    
    void dfs(String airport, List<String> result) {
        if(result.size() == resultSize) {
            results.add(List.copyOf(result));
            return;
        }
        
        List<Integer> list = map.get(airport);
        if(list == null) return;
        
        for(int npIdx : list) {
            if(used[npIdx]) continue;
            
            String np = tickets[npIdx][1];
            
            used[npIdx] = true;
            int idx = result.size();
            result.add(np);
            
            dfs(np, result);
            
            used[npIdx] = false;
            result.remove(idx);
        }
    }
}