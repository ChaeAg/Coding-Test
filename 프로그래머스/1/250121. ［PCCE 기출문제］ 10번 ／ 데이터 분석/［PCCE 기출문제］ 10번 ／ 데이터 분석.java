import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> cutting = new ArrayList();
        int cutting_idx = 0;
        
        switch(ext) {
            case "code" :
                cutting_idx = 0;
                break;
            case "date" :
                cutting_idx = 1;
                break;
            case "maximum" :
                cutting_idx = 2;
                break;
            case "remain" :
                cutting_idx = 3;
                break;
        }
        
        for(int i=0; i<data.length; i++) {
            if(data[i][cutting_idx] >= val_ext) continue;
            cutting.add(data[i]);
        }
        
        int sort_idx = 0;
        
        switch(sort_by) {
            case "code" :
                sort_idx = 0;
                break;
            case "date" :
                sort_idx = 1;
                break;
            case "maximum" :
                sort_idx = 2;
                break;
            case "remain" :
                sort_idx = 3;
                break;
        }
        
        final int final_sort_idx = sort_idx;
        
        Collections.sort(cutting, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[final_sort_idx] < o2[final_sort_idx]){
                	return -1;
                }
                if(o1[final_sort_idx] > o2[final_sort_idx]){
                    return 1;
                }
                return 0;
            }
        });
        
        return cutting.stream()
            .toArray(int[][]::new); 
    }
}