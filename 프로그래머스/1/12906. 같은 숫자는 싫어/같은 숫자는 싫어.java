import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        List<Integer> list = new ArrayList();
        list.add(arr[0]);
        
        Arrays.stream(arr)
            .filter(i -> list.get(list.size()-1) != i)
            .forEach(i -> list.add(i));
        
        return list;
    }
}