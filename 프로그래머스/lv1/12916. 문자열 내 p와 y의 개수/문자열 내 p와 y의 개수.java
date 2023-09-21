class Solution {
    boolean solution(String s) {
        int pcnt = 0, ycnt = 0;
        
        for(String i : s.toLowerCase().split("")) {
            if(i.equals("p")) pcnt++;
            else if(i.equals("y")) ycnt++;
        }

        return pcnt == ycnt ? true : false;
    }
}