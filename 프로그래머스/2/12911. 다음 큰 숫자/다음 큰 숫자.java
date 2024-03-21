class Solution {
    public int solution(int n) {
        int answer = 0;
        int counta = 0, countb;
        String two_n = Integer.toBinaryString(n);
        String two_a;
        
        for(int i=0; i<two_n.length(); i++){
            if(two_n.charAt(i) == '1') counta++;
        }
        
        for(int i=n+1; i<=1000000; i++){
            two_a = Integer.toBinaryString(i);
            countb = 0;
            for(int k=0; k<two_a.length(); k++){
                if(two_a.charAt(k) == '1') countb++;
            }
            if(counta == countb){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}