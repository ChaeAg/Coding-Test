class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        String[] strs = s.split("");
        boolean isFirst = true;
                
        for(int i=0; i<strs.length; i++) {
            if(strs[i].equals(" ")) {
                isFirst = true;
                continue;
            }
            if(isFirst) {
                strs[i] = strs[i].toUpperCase();
                isFirst = false;
            }
        }
        
        return String.join("", strs);
    }
}