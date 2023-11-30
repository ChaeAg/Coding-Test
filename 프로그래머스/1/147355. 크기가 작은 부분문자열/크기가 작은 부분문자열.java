class Solution {
    public int solution(String t, String p) {
        int count = 0;
        for(int i=0; i<=t.length()-p.length(); i++) {
            if(Long.valueOf(t.substring(i, i+p.length())) <= Long.valueOf(p)) count++;
        }
        return count;
    }
}