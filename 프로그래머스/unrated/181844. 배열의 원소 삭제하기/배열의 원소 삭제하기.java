import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = IntStream.of(arr).boxed()
            .collect(Collectors.toList());

        for(int item : delete_list) {
            if(list.contains(item)) {
                list.remove(list.indexOf(item));
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}