class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int columnSize = arr1.length;
        int rowSize = arr1[0].length;
        int[][] answer = new int[columnSize][rowSize];
        for(int i=0; i<columnSize; i++) {
            for(int j=0; j<rowSize; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}