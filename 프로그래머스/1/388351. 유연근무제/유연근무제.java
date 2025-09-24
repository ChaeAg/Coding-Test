class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        int answer = n;
        for (int i = 0; i < n; i++) {
            int kijun = schedules[i] + (schedules[i] / 10 % 10 == 5 ? 50 : 10);
            for (int j = 0; j < 7; j++) {
                if (timelogs[i][j] > kijun && (startday + j) % 7 != 6 && (startday + j) % 7 != 0) {
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }
}