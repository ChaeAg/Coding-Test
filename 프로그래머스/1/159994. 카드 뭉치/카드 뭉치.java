class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int cards1Idx = 0;
        int cards2Idx = 0;
        int goalIdx = 0;
        
        while(goalIdx < goal.length) {
            if(cards1Idx < cards1.length && goal[goalIdx].equals(cards1[cards1Idx])) {
                goalIdx++;
                cards1Idx++;
            }
            else if(cards2Idx < cards2.length && goal[goalIdx].equals(cards2[cards2Idx])) {
                goalIdx++;
                cards2Idx++;
            }
            else {
                answer = "No";
                break;
            }
        }
        
        return answer;
    }
}