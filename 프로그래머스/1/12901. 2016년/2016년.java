class Solution {
    public String solution(int a, int b) {
        int[] date = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        
        for(int i=0; i<a-1; i++) {
            b += date[i];
        }
        
        return days[b % 7];
    }
}