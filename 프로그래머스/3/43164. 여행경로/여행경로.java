// import java.util.*;
// class Solution {
//     static List<String[]> answer = new ArrayList<>();
//     static int len;
//     static Map<String, List<String>> map = new HashMap<>();
//     public String[] solution(String[][] tickets) {
//         len = tickets.length;
//         List<List<String>> list = new ArrayList<>();
        
//         for(String[] ticket : tickets) {
//             List<String> temp = map.getOrDefault(ticket[0], new ArrayList<>());
//             temp.add(ticket[1]);
//             map.put(ticket[0], temp);
                
//             list.add(List.of(ticket[0], ticket[1]));
//         }
        
//         String[] path = new String[len+1];
//         path[0] = "ICN";
//         dfs("ICN", 1, path, list);
        
//         // TODO: 알파벳순 정렬
//         Collections.sort(answer, (a, b) -> {
//             int l = a.length-1;
//             for(int i=0; i<=l; i++) {
//                 int cmp = a[i].compareTo(b[i]);
//                 if(cmp != 0) {
//                     return a[i].compareTo(b[i]);
//                 }
//             }
//             return a[l].compareTo(b[l]);
//         });
        
//         return answer.get(0);
//     }
    
//     static void dfs(String airport_name, int depth, String[] path, List<List<String>> list) {
//         if(depth == len) {
//             path[depth] = list.get(0).get(1);
//             answer.add(path.clone());
//             return;
//         }
        
//         List<String> connect = map.get(airport_name);
        
//         if(connect == null || connect.isEmpty()) return;
        
//         for(String s : connect) {
//             List<String> pair = List.of(airport_name, s);
//             int idx = list.indexOf(pair);
            
//             // 이미 사용한 티켓인가?
//             if(idx == -1) continue;
            
//             path[depth] = s;
//             list.remove(idx);
            
//             dfs(s, depth+1, path, list);
                
//             path[depth] = null;
//             list.add(pair);
//         }
//     }
// }


import java.util.*;
class Solution {
    
    List<List<String>> results = new ArrayList<>();
    Map<String, List<String>> connect = new HashMap<>();
    int result_len_format;
    
    public String[] solution(String[][] tickets) {
        result_len_format = tickets.length + 1; // 항공권이 n개일때 경로의 방문 나라 수는 n+1개다.
        
        for(String[] strs : tickets) {
            connect.computeIfAbsent(strs[0], k -> new ArrayList<>()).add(strs[1]);
        }
        
        String[] str = new String[result_len_format]; // 출발지 ICN 세팅
        str[0] = "ICN";
        
        for(String connect_contry : new ArrayList<>(connect.get("ICN"))) {
            /*
              각 ICN 출발 티켓을 출발 티켓으로 선택하고 DFS
              BFS가 아닌 이유? -> 티켓 사용 체크(visited)를 해줬다가 풀어줬다가 하는 작업이 필요한데
                               BFS는 큐에 넣는거니까 이게 안된다.
            */
            
            connect.get("ICN").remove(connect_contry); // ICN -> {connect_contry} 항공권 사용

            dfs(connect_contry, 1, str);
            
            connect.get("ICN").add(connect_contry); // 항공권 복구
        }
        
        results.sort((list1, list2) -> {
            for(int i=0; i<list1.size(); i++) {
                String str1 = list1.get(i);
                String str2 = list2.get(i);
                
                int com = str1.compareTo(str2);
                
                if(com != 0) return com;
            }
            
            return 0;
        });
        
        return results.get(0).toArray(new String[result_len_format]);
    }
    
    public void dfs(String now_country, int use_count, String[] result) {
        result[use_count] = now_country;
        
        if(use_count >= result_len_format - 1) {
            results.add(List.of(result));
            return;
        }
        
        if(connect.get(now_country) == null) return; // now_contry에서 출발하는 항공권이 현재 없을 때 종료
        
        for(String connect_contry : new ArrayList<>(connect.get(now_country))) {
            // {now_contry} -> {connect_contry} 항공권 사용
            connect.get(now_country).remove(connect_contry);
            dfs(connect_contry, use_count + 1, result);
            connect.get(now_country).add(connect_contry);
        }
    }
}
