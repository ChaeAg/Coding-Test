import java.util.*;

class Solution {
    public List<Integer> solution(int n, int[] slicer, int[] num_list) {
        List<Integer> list = new ArrayList();
        
        switch (n) { // n에 따라 다른 for문 적용
            case 1: // 0 ~ b 인덱스까지 슬라이싱
                for(int i=0; i<=slicer[1]; i++) list.add(num_list[i]);
                break;
            case 2: // a ~ 마지막 인덱스까지 슬라이싱
                for(int i=slicer[0]; i<num_list.length; i++) list.add(num_list[i]);
                break;
            case 3: // a ~ b 인덱스까지 슬라이싱
                for(int i=slicer[0]; i<=slicer[1]; i++) list.add(num_list[i]);
                break;
            case 4: // a ~ b 인덱스까지 c 간격으로 슬라이싱
                for(int i=slicer[0]; i<=slicer[1]; i += slicer[2]) list.add(num_list[i]);
                break;
        }
        
        return list;
    }
}