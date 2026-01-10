class Solution {
    int n;
    int[] info;
    
    int winCase_maxCha = 0;
    int[] temp = new int[11];
    int[] result = new int[11];
    boolean foundWin = false;
    
    public int[] solution(int n, int[] info) {
        this.n = n;
        this.info = info;
        
        dfs(0, 0, 0, 0);
        
        if(!foundWin) {
            result = new int[1];
            result[0] = -1;
        }
        
        return result;
    }
    
    void dfs(int turn, int useArrowCnt, int nowLionScore, int apeachScore) {
        if(turn > 10) {
            // 남은 화살을 temp[10]에 추가
            int remainArrow = 0;
            if(useArrowCnt < n) {
                remainArrow = n - useArrowCnt;
                temp[10] += remainArrow;
            }
            
            int scoreDiff = nowLionScore - apeachScore;
            
            if(scoreDiff > 0) {
                foundWin = true;
                
                if(scoreDiff > winCase_maxCha) {
                    // 점수 차이가 더 크면 무조건 갱신
                    winCase_maxCha = scoreDiff;
                    for(int i=0; i<11; i++) {
                        result[i] = temp[i];
                    }
                } else if(scoreDiff == winCase_maxCha) {
                    // 점수 차이가 같으면 낮은 점수를 더 많이 맞힌 경우 선택
                    if(isLowerScorePreferred(temp, result)) {
                        for(int i=0; i<11; i++) {
                            result[i] = temp[i];
                        }
                    }
                }
            }
            
            // temp[10] 복구
            if(remainArrow > 0) {
                temp[10] -= remainArrow;
            }
            
            return;
        }
        
        // 안쓰기
        dfs(turn + 1, useArrowCnt, nowLionScore, 
            (info[turn] > 0 ? apeachScore + (10 - turn) : apeachScore));
        
        // 화살 쓰기
        if(n - useArrowCnt > info[turn]) {
            int nowUseArrowCnt = info[turn] + 1;
            temp[turn] = nowUseArrowCnt;
            
            dfs(turn+1, useArrowCnt + nowUseArrowCnt, 
                nowLionScore+(10-turn), apeachScore);
            
            temp[turn] = 0;
        }
    }
    
    // 낮은 점수를 더 많이 맞혔는지 확인 (10점부터 역순으로)
    boolean isLowerScorePreferred(int[] temp, int[] result) {
        for(int i=10; i>=0; i--) {
            if(temp[i] > result[i]) {
                return true;  // temp가 더 낮은 점수에 많이 맞춤
            } else if(temp[i] < result[i]) {
                return false;  // result가 더 낮은 점수에 많이 맞춤
            }
        }
        return false;  // 완전히 동일
    }
}