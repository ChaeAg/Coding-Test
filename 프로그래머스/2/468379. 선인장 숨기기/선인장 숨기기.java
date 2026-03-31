import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        final int INF = Integer.MAX_VALUE;

        // 각 칸에 몇 번째 빗방울이 떨어지는지
        int[][] time = new int[m][n];
        for (int[] row : time) Arrays.fill(row, INF);
        for (int i = 0; i < drops.length; i++) {
            time[drops[i][0]][drops[i][1]] = i + 1;
        }

        // 각 행에서 폭 w의 가로 슬라이딩 최솟값
        int cols = n - w + 1;
        int[][] rowMins = new int[m][cols];
        for (int r = 0; r < m; r++) {
            slidingMin(time[r], w, rowMins[r]);
        }

        // rowMins의 각 열에서 높이 h의 세로 슬라이딩 최솟값
        int rows = m - h + 1;
        int[][] result = new int[rows][cols];
        int[] colArr = new int[m];
        int[] colOut = new int[rows];
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < m; r++) {
                colArr[r] = rowMins[r][c];
            }
            slidingMin(colArr, h, colOut);
            for (int r = 0; r < rows; r++) {
                result[r][c] = colOut[r];
            }
        }

        int bestVal = -1, bestR = 0, bestC = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (result[r][c] > bestVal) {
                    bestVal = result[r][c];
                    bestR = r;
                    bestC = c;
                }
            }
        }

        return new int[]{bestR, bestC};
    }

    // 1차원 슬라이딩 윈도우 최솟값 구하는 함수
    private void slidingMin(int[] arr, int k, int[] out) {
        Deque<int[]> dq = new ArrayDeque<>(); // [값, 인덱스]
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            // 뒤에서 현재 값보다 크거나 같은 것 제거
            while (!dq.isEmpty() && dq.peekLast()[0] >= arr[i]) {
                dq.pollLast();
            }
            dq.addLast(new int[]{arr[i], i});
            // 앞에서 윈도우를 벗어난 것 제거
            while (dq.peekFirst()[1] <= i - k) {
                dq.pollFirst();
            }
            // 윈도우가 완성된 시점부터 결과 기록
            if (i >= k - 1) {
                out[idx++] = dq.peekFirst()[0];
            }
        }
    }
}