class Solution {
    public String solution(String s) {
        int idxCount = 0;
        String[] str = s.split("");
        String result = "";
        for(int i=0; i<str.length; i++) {
            if(str[i].equals(" ")) {
                result += " ";
                idxCount = 0;
            }
            else {
                if(idxCount % 2 == 0) result += str[i].toUpperCase();
                else result += str[i].toLowerCase();
                idxCount++;
            }
        }
        
        return result;
    }
}