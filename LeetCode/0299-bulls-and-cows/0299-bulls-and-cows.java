class Solution {
    public String getHint(String secret, String guess) {
        char[] secretChars = secret.toCharArray();
        char[] guessChars = guess.toCharArray();

        int idx = -1;
        int bullsCnt = 0, cowsCnt = 0;
        int[] secretNumCnt = new int[10]; // secret 문자열을 순회하면서 0~9까지 등장 빈도를 셈
        int[] guessNumCnt = new int[10]; // guess 문자열을 순회하면서 0~9까지 등장 빈도를 셈
        while(++idx < secretChars.length) {
            if(secretChars[idx] == guessChars[idx]) {
                bullsCnt++;
            } else {
                int num = secretChars[idx] - '0';
                if(guessNumCnt[num] > 0) {
                    cowsCnt++;
                    guessNumCnt[num]--;
                } else {
                    secretNumCnt[num]++;
                }

                num = guessChars[idx] - '0';
                if(secretNumCnt[num] > 0) {
                    cowsCnt++;
                    secretNumCnt[num]--;
                } else {
                    guessNumCnt[num]++;
                }
            }
        }

        return bullsCnt + "A" + cowsCnt + "B";
    }
}