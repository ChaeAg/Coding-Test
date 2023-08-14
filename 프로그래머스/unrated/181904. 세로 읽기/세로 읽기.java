class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        String[] s = new String[m];
        int k=0;
        
        for(int i=0; i<s.length; i++)
            s[i] = "";
        
        for(int i=0; i<my_string.length(); i++, k++){
            if(k == m) k = 0;
            s[k] += my_string.substring(i,i+1);
        }
        
        return s[c-1];
    }
}