class Solution {
    public int solution(String[] strArr) {
        int idx, max = 0;
        int[] arr = new int[30];
        
        for(String s:strArr) {
            arr[s.length()-1]++;
            if(max < arr[s.length()-1]) max = arr[s.length()-1];
        }
        
        return max;
    }
}