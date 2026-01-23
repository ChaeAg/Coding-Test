class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        
        int size = board.length;
        int len = board[0].length;
        
        int[][] b = new int[size+1][len+1]; // 맨 왼쪽과 윗쪽에 패딩 1씩 추가
        for(int i=1; i<=size; i++) {
            for(int j=1; j<=len; j++) {
                b[i][j] = board[i-1][j-1];
            }
        }
        
        for(int i=1; i<=size; i++) {
            for(int j=1; j<=len; j++) {
                int min = Math.min(b[i-1][j-1], Math.min(b[i-1][j], b[i][j-1])); // 왼, 왼위, 위 이렇게 비교해서 최솟값 찾기
                
                if(min != 0 && b[i][j] != 0) {
                    b[i][j] = min + 1;
                }
            }
        }
        
        for(int[] arr : b) {
            for(int i : arr) {
                answer = Math.max(answer, i);
            }
        }
        
        return (int) Math.pow(answer, 2);
    }
}