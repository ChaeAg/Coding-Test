import java.util.*;

class Solution {
    static String[][] b;
    static List<int[]> remove;
    static int c_n, c_m;
    static int[][] move = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}}; // 왼위, 오위, 왼아래, 오아래
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        c_n = n; c_m = m;
        b = new String[m][n];

        for(int i=0; i<m; i++) {
            b[i] = board[i].split("");
        }

        while(true) {
            remove = new ArrayList<>();
            boolean[][] isRemoved = new boolean[m][n];
            
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(b[i][j].isBlank()) continue;
                    search(i, j);
                }
            }

            if(remove.isEmpty()) break; // 더 이상 지울 블록이 없을 때 끝.

            remove.sort(Comparator.comparingInt(a -> a[0])); // 블럭이 위에서 아래로 지워질 수 있도록 정렬

            for(int[] arr : remove) {
                int i = arr[0];
                int j = arr[1];

                if(isRemoved[i][j]) continue; // remove에 중복 값이 있기 때문에 체크해줌

                for(int k=i; k>0; k--) { // 그 블록 위치를 기준으로 위 블록이 한칸씩 내려옴
                    if(b[k-1][j].isBlank()) break;

                    b[k][j] = b[k-1][j];
                    b[k-1][j] = ""; // 내려온 블록이 있던 자리는 비워줌
                }

                answer++;
                isRemoved[i][j] = true;
            }
        }

        return answer;
    }

    public static void search(int i, int j) {
        String character = b[i][j];

        for(int k=0; k<4; k++) { // 왼위, 오위, 왼아래, 오아래 돎
            int target_i = i + move[k][0];
            int target_j = j + move[k][1];

            if(target_i < 0 || target_i >= c_m || target_j < 0 || target_j >= c_n) continue;
            if(!b[target_i][target_j].equals(character) || !b[target_i][j].equals(character) || !b[i][target_j].equals(character)) continue;

            // 2x2 개가 모두 같은 블록이면 지워야 할 목록에 저장
            remove.add(new int[]{i, j});
            remove.add(new int[]{target_i, j});
            remove.add(new int[]{i, target_j});
            remove.add(new int[]{target_i, target_j});
        }
    }
    
}