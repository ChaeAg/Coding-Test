class Solution {
     public int countBinarySubstrings(String s) {
        int result = 0;
        char[] chars = s.toCharArray();

        int diffCnt = 0;
        int beforeCnt = 1;
        char before = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (before != chars[i]) { // 전 문자와 현 문자가 다르다
                diffCnt++;
                result++;
                if (diffCnt >= beforeCnt) { // 전 문자의 연속수와 같아졌다 (최대)
                    beforeCnt = diffCnt;
                    diffCnt = 0;
                    before = chars[i];
                }
            } else if (before == chars[i]) { // 전 문자와 현 문자가 같다
                if (diffCnt > 0) { // 현 문자 연속이 끝났다
                    beforeCnt = diffCnt;
                    diffCnt = 0;
                    before = chars[i] == '0' ? '1' : '0';
                    i--;
                } else { // 연속중이다
                    beforeCnt++;
                }
            }
        }

        return result;
    }
}