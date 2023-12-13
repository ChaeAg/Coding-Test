import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList();
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int correct1 = 0, correct2 = 0, correct3 = 0;
        int idx1 = 0, idx2 = 0, idx3 = 0;
        
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == arr1[idx1]) correct1++;
            if(answers[i] == arr2[idx2]) correct2++;
            if(answers[i] == arr3[idx3]) correct3++;
            idx1++;
            idx2++;
            idx3++;
            if(idx1 >= arr1.length) idx1 = 0;
            if(idx2 >= arr2.length) idx2 = 0;
            if(idx3 >= arr3.length) idx3 = 0;
        }
        int max = 0;
        if(correct1 > max) max = correct1;
        if(correct2 > max) max = correct2;
        if(correct3 > max) max = correct3;
        
        if(max == correct1) answer.add(1);
        if(max == correct2) answer.add(2);
        if(max == correct3) answer.add(3);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}