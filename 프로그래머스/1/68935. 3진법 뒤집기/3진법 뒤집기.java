class Solution {
    public int solution(int n) {        
        String[] arr = Integer.toString(n, 3).split("");
        String a = "";
        
        for(int i=arr.length-1; i>=0; i--) {
            a += arr[i];
        }
        
        return Integer.parseInt(a, 3);
    }
}