class Solution {
    public String solution(String new_id) {
        //1단계
        new_id = new_id.toLowerCase();

        //2단계
        for(char c : new_id.toCharArray()) {
            if((c > 96 && c < 123) || (c > 47 && c < 58) || c == '-' || c == '_' || c == '.') {
                continue;
            }
            new_id = new_id.replace(String.valueOf(c), "");
        }

        //3단계
        int startIdx = -1, endIdx = -1, idx = 0;
        while(idx < new_id.length()) {
            if(new_id.charAt(idx) == '.') {
                if(startIdx == -1) { // '.' 첫 발견
                    startIdx = idx;
                    endIdx = startIdx;
                }
                else { // 직전 문자도 '.'
                    endIdx++;
                }
            }
            else {
                if(endIdx != startIdx) { // 마침표 여러번 나왔을 때
                    new_id = new_id.substring(0, startIdx) + "." + new_id.substring(endIdx + 1);
                    idx -= endIdx - startIdx;
                }
                startIdx = -1;
                endIdx = -1;
            }
            idx++;
        }
        if(endIdx != startIdx) new_id = new_id.substring(0, startIdx) + "." + new_id.substring(endIdx+1);

        //4단계
        if(new_id.startsWith(".")) new_id = new_id.substring(1);
        if(new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length()-1);

        //5단계
        if(new_id.equals("")) new_id = "a";

        //6단계
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if(new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length()-1);
        }

        //7단계
        if(new_id.length() <= 2) {
            String lastWord = new_id.substring(new_id.length()-1);
            while(new_id.length() < 3) {
                new_id += lastWord;
            }
        }
        
        return new_id;
    }
}