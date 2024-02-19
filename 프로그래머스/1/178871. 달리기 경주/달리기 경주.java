import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerMap = new HashMap<>();
        
        for(int i=0; i<players.length; i++) {
            playerMap.put(players[i], i);
        }
        
        for(String call : callings) {
            int ranking = playerMap.get(call);
            playerMap.replace(players[ranking - 1], ranking);
            playerMap.replace(call, ranking - 1);
            players[ranking] = players[ranking - 1];
            players[ranking - 1] = call;
        }
        
        return players;
    }
}