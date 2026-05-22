import java.util.*;
class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> result = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();

        for(int i=0; i<keyName.length; i++) {
            String[] times = keyTime[i].split(":");
            int time = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            List<Integer> l = map.getOrDefault(keyName[i], new ArrayList<>());
            l.add(time);
            map.put(keyName[i], l);
        }

        for(String key : map.keySet()) {
            List<Integer> times = map.get(key);
            if(times.size() < 3) continue;

            Collections.sort(times);

            for(int i=0; i<times.size()-2; i++) {
                if(Math.abs(times.get(i+2) - times.get(i)) <= 60) {
                    result.add(key);
                    break;
                }
            }
        }

        Collections.sort(result);
        return result;
    }
}