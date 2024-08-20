import java.util.*;

class Solution {
    static String[][] b;
    static List<int[]> remove;
    static int c_n, c_m;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
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
                        check_1(i, j);
                        check_2(i, j);
                        check_3(i, j);
                        check_4(i, j);
                    }
                }

                if(remove.isEmpty()) break;

                remove.sort(Comparator.comparingInt(a -> a[0]));

                for(int[] arr : remove) {
                    int i = arr[0];
                    int j = arr[1];

                    if(isRemoved[i][j]) continue;

                    for(int k=i; k>0; k--) {
                        if(b[k-1][j].isBlank()) break;

                        b[k][j] = b[k-1][j];
                        b[k-1][j] = "";
                    }

                    answer++;
                    isRemoved[i][j] = true;
                }
            }

            return answer;
        }

        //왼-위 대각선
        public static void check_1(int i, int j) {
            String character = b[i][j];
            int target_i = i-1;
            int target_j = j-1;

            if(target_i < 0 || target_j < 0 || !b[target_i][target_j].equals(character)) return; // 왼위
            if(!b[target_i][j].equals(character)) return; // 위
            if(!b[i][target_j].equals(character)) return; // 왼

            // 4개가 다같으면 여기로
            remove.add(new int[]{i-1, j-1});
            remove.add(new int[]{i-1, j});
            remove.add(new int[]{i, j-1});
            remove.add(new int[]{i, j});
        }

        //오-위 대각선
        public static void check_2(int i, int j) {
            String character = b[i][j];
            int target_i = i-1;
            int target_j = j+1;

            if(target_i < 0 || target_j >= c_n || !b[target_i][target_j].equals(character)) return; // 오위
            if(!b[target_i][j].equals(character)) return; // 위
            if(!b[i][target_j].equals(character)) return; // 오

            // 4개가 다같으면 여기로
            remove.add(new int[]{i-1, j+1});
            remove.add(new int[]{i-1, j});
            remove.add(new int[]{i, j+1});
            remove.add(new int[]{i, j});
        }

        //오-아래 대각선
        public static void check_3(int i, int j) {
            String character = b[i][j];
            int target_i = i+1;
            int target_j = j+1;

            if(target_i >= c_m || target_j >= c_n || !b[target_i][target_j].equals(character)) return; // 오아래
            if(!b[target_i][j].equals(character)) return; // 아래
            if(!b[i][target_j].equals(character)) return; // 오

            // 4개가 다같으면 여기로
            remove.add(new int[]{i+1, j+1});
            remove.add(new int[]{i+1, j});
            remove.add(new int[]{i, j+1});
            remove.add(new int[]{i, j});
        }

        //왼-아래 대각선
        public static void check_4(int i, int j) {
            String character = b[i][j];
            int target_i = i+1;
            int target_j = j-1;

            if(target_i >= c_m || target_j < 0 || !b[target_i][target_j].equals(character)) return; // 왼아래
            if(!b[target_i][j].equals(character)) return; // 아래
            if(!b[i][target_j].equals(character)) return; // 왼

            // 4개가 다같으면 여기로
            remove.add(new int[]{i+1, j-1});
            remove.add(new int[]{i+1, j});
            remove.add(new int[]{i, j-1});
            remove.add(new int[]{i, j});
        }
}