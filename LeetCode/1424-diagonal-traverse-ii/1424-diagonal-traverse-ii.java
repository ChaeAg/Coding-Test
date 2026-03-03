import java.util.*;
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<nums.size(); i++) {
            List<Integer> tmp = nums.get(i);
            for(int j=0; j<tmp.size(); j++) {
                list.add(new int[]{i+j, i, tmp.get(j)});
            }
        }

        list.sort((o1, o2) -> {
            if(o1[0] == o2[0]) return o2[1] - o1[1];
            return o1[0] - o2[0];
        });

        return list.stream().map(l -> l[2]).mapToInt(Integer::valueOf).toArray();
    }
}