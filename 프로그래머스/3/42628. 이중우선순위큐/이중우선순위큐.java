import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> ascending_q = new PriorityQueue<>();
        PriorityQueue<Integer> descending_q = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(String oper : operations) {
            String[] strs = oper.split(" ");
            if(strs[0].equals("I")) {
                ascending_q.add(Integer.parseInt(strs[1]));
                descending_q.add(Integer.parseInt(strs[1]));
            }
            else {
                if(strs[1].startsWith("-")) {
                    if(!ascending_q.isEmpty()) {
                        descending_q.remove(ascending_q.poll());
                    }
                }
                else {
                    if(!descending_q.isEmpty()) {
                        ascending_q.remove(descending_q.poll());
                    }
                }
            }
        }
        
        if(!ascending_q.isEmpty() && !descending_q.isEmpty()) {
            answer[0] = descending_q.poll();
            answer[1] = ascending_q.poll();
        }
        
        return answer;
    }
}