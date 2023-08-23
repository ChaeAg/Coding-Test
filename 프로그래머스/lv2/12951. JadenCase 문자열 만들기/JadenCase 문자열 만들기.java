class Solution {
    public String solution(String s) {
        String answer = "";
        int[] ascarr = new int[s.length()];
        String[] sarr = s.split("");
        
        for(int i=0; i<s.length(); i++){
            ascarr[i] = s.charAt(i); // 문자열을 모두 아스키코드로 변환한 배열
        }
        //영어 알파벳 아스키코드 A~Z:65~90, a~z:97~122
        for(int i=0; i<sarr.length; i++){
            if(i == 0){
                if(ascarr[i] > 64 && ascarr[i] < 123){
                    sarr[i] = sarr[i].toUpperCase();
                }
            }
            else if(sarr[i-1].equals(" ") && ascarr[i] > 64 
                    && ascarr[i] < 123){
                sarr[i] = sarr[i].toUpperCase();
            }
            else if(ascarr[i] > 64 && ascarr[i] < 123){
                sarr[i] = sarr[i].toLowerCase();
            }
            answer += sarr[i];
        }
        
        return answer;
    }
}