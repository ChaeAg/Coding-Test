class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String word : babbling) {
            int len = word.length();
            word = word.replaceAll("ayaaya", "?")
                .replaceAll("yeye", "?")
                .replaceAll("woowoo", "?")
                .replaceAll("mama", "?"); 
            word = word.replaceAll("aya", "---")
                .replaceAll("ye", "--")
                .replaceAll("woo", "---")
                .replaceAll("ma", "--");
            if(!word.contains("?") && word.equals("-".repeat(len))) answer++;
        }
        
        return answer;
    }
}