class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
    });

        int end = meetings[0][1];
        int cnt = meetings[0][0] - 1;
        for(int i=1; i<meetings.length; i++) {
            if(meetings[i][0] <= end) {
                end = Math.max(end, meetings[i][1]);
            } else {
                cnt += meetings[i][0] - end - 1;
                end = meetings[i][1];
            }
        }

        return cnt + days - end;
    }
}