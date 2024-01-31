class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for(int i=0; i<targets.length; i++) {
            String[] word = targets[i].split("");
            int count = 0;
            for(String w : word) {
                int minCount = 101;
                for(String key : keymap) {
                    if(key.contains(w) && key.indexOf(w) + 1 < minCount) {
                        minCount = key.indexOf(w) + 1;
                    }
                }
                if(minCount == 101) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += minCount;
            }
        }
        
        return answer;
    }
}