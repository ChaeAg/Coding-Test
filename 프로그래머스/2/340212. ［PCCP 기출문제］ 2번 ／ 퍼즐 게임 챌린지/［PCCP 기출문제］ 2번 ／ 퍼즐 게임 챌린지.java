class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int maxDiff = 0;
        for(int diff : diffs) {
            maxDiff = Math.max(maxDiff, diff);
        }
        
        int puzzleCnt = diffs.length;
        int answer = maxDiff;
        int left = 0, right = maxDiff;
        while(left < right) {
            int level = (left + right) / 2;
            if(level <= 0) break;
            
            long solveTotalTime = 0L;
            for(int i=0; i<puzzleCnt; i++) {
                solveTotalTime += times[i];
                if(diffs[i] > level) {
                    if(i > 0) {
                        solveTotalTime += (times[i] + times[i-1]) * (diffs[i] - level);
                    } else {
                        solveTotalTime += times[i] * (diffs[i] - level);
                    }
                }
            }
            
            if(solveTotalTime > limit) {
                left = level+1;
            } else if(solveTotalTime < limit) {
                right = level;
                answer = answer > level ? level : answer;
            } else {
                answer = level;
                break;
            }
        }
        
        return answer;
    }
}