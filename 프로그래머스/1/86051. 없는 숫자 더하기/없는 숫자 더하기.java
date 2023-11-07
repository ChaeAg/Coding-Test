import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        List<Integer> list = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        for(int num : numbers) {
            if(list.contains(num)) {
				list.remove(list.indexOf(num));
			}
        }
        return list.stream().mapToInt(Integer::intValue).sum();
    }
}