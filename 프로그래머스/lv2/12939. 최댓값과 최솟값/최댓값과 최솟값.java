class Solution {
    public String solution(String s) {
        String[] sarr = s.split(" ");
        int[] arr = new int[sarr.length];
        int min=Integer.parseInt(sarr[0]), max=Integer.parseInt(sarr[0]);
        
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(sarr[i]);
        } 
        
        for(int i:arr) min = Math.min(min,i); // 최솟값 구하기
        for(int i:arr) max = Math.max(max,i); // 최댓값 구하기
        
        return String.valueOf(min) + " " + String.valueOf(max);
    }
}