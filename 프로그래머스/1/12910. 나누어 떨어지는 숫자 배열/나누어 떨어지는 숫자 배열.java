import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> solution(int[] arr, int divisor) {
        List<Integer> list = Arrays.stream(arr)
                                .filter(i -> i % divisor == 0)
                                .sorted()
                                .boxed()
                                .collect(Collectors.toList());

        return list.isEmpty() ? Collections.singletonList(-1) : list;
    }
}
