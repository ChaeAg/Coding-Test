class Solution {
    public String solution(String my_string, int s, int e) {
        char[] c = my_string.toCharArray();
        char[] t = new char[my_string.length()];
        
        for(int i=s,k=0; i<=e; i++,k++) t[k] = c[i];
        for(int i=e,k=0; i>=s; i--,k++) c[i] = t[k];

        return String.valueOf(c);
    }
}