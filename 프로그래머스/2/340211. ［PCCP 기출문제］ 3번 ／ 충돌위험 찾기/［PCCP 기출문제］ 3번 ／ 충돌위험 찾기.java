class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int robotCnt = routes.length;
        int[] routeIdx = new int[robotCnt];

        int[][] robotIdx = new int[robotCnt][2]; // [로봇 번호][0] = x, [로봇 번호][1] = y
        int[] pointRobotCnt = new int[points.length + 1];
        for (int i = 0; i < robotCnt; i++) {
            // 로봇 초기 위치 세팅
            robotIdx[i][0] = points[routes[i][0] - 1][0];
            robotIdx[i][1] = points[routes[i][0] - 1][1];

            pointRobotCnt[routes[i][0]]++;
            if (pointRobotCnt[routes[i][0]] == 2) {
                answer++;
            }
        }

        int completeCnt = 0;
        boolean[] isCompleteRobot = new boolean[robotCnt];
        while (completeCnt < robotCnt) {
            int[][] pointVisitCnt = new int[101][101];
            for (int i = 0; i < robotCnt; i++) {
                if (isCompleteRobot[i]) {
                    continue;
                }

                int nowX = robotIdx[i][0];
                int nowY = robotIdx[i][1];
                int[] targetPoint = points[routes[i][routeIdx[i] + 1] - 1];
                int targetX = targetPoint[0];
                int targetY = targetPoint[1];

                int nextX = nowX;
                int nextY = nowY;

                if (nowX != targetX) { // x좌표 이동 우선
                    if (nowX < targetX) {
                        nextX++;
                    } else {
                        nextX--;
                    }
                } else { // x좌표가 같다면 y좌표 이동
                    if (nowY < targetY) {
                        nextY++;
                    } else {
                        nextY--;
                    }
                }

                robotIdx[i][0] = nextX;
                robotIdx[i][1] = nextY;

                pointVisitCnt[nextX][nextY]++;
                if (pointVisitCnt[nextX][nextY] == 2) {
                    answer++;
                }

                if (robotIdx[i][0] == targetX && robotIdx[i][1] == targetY) { // 도착
                    if (routes[i].length - 2 == routeIdx[i]) { // 마지막 도착지까지 도착
                        isCompleteRobot[i] = true;
                        completeCnt++;
                    } else {
                        routeIdx[i]++;
                    }
                }
            }
        }

        return answer;
    }
}