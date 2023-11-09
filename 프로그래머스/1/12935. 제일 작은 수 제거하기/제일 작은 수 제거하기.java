import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public List<Integer> solution(int[] arr) {
        if(arr.length < 2) return List.of(-1);
        List<Integer> list = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.toList());
        list.remove(list.indexOf(Arrays.stream(arr)
                                 .min()
                                 .getAsInt()));
        return list;
    }
}