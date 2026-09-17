import java.util.*;
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();     
        for(int t : time) {
            int n = t % 60;
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        // for(int key : map.keySet()) {
        //     System.out.println(key + ":" + map.get(key));
        // }

        int c = 0;
        int c1 = map.getOrDefault(0, 0);
        if(c1 != 0) {
            for(int i=0; i<c1-1; i++) {
                for(int j=i+1; j<c1; j++) {
                    c++;
                }
            }
        }
        c1 = map.getOrDefault(30, 0);
        if(c1 != 0) {
            for(int i=0; i<c1; i++) {
                for(int j=i+1; j<c1; j++) {
                    c++;
                }
            }
        }

        for(int t=59; t>30; t--) {
            Integer i = map.get(t);
            if(i != null) {
                c += map.getOrDefault(60 - t, 0) * i;
            }
        }
        return c;
    }
}