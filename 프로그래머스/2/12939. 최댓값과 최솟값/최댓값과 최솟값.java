class Solution {
    public String solution(String s) {
        String[] strs = s.split(" ");
        int min = Integer.parseInt(strs[0]);
        int max = Integer.parseInt(strs[0]);
    
        for(String str : strs) {
            int num = Integer.parseInt(str);
            if(num < min) 
                min = num;
            if(num > max)
                max = num;
        }
        
        return min + " " + max;
    }
}