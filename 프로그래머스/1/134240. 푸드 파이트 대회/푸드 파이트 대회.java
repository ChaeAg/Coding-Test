class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<food.length; i++) {
            for(int k=0; k<(food[i] / 2); k++) {
                sb.append(i);
            }
        }
        String reverse = sb.reverse().toString();
        sb.reverse().append("0").append(reverse);
        
        return sb.toString();
    }
}