class Solution {
    public int solution(String[] babbling) {
        int count = 0;
        for(String str:babbling) {
            String result = str;
            result = result.replace("aya", " ");
            result = result.replace("ye", " ");
            result = result.replace("woo", " ");
            result = result.replace("ma", " ");
            if(result.isBlank()) count++;
        }
        return count;
    }
}