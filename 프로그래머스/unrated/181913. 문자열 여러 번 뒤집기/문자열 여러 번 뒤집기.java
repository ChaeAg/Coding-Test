class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] c = my_string.toCharArray();
        int k;
        
        for(int[] query:queries){
            char[] aa = new char[my_string.length()];
            k = 0;
            for(int i=query[0]; i<=query[1]; i++, k++) aa[k] = c[i];
            k--;
            for(int i=query[0]; i<=query[1]; i++, k--) c[i] = aa[k];
        }
        
        return String.valueOf(c);
    }
}