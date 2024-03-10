import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] check = new boolean[5][5];
    static String[][] board = new String[5][5];
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int min_move = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<5; i++) {
            board[i] = br.readLine().split(" ");
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bt(r, c, 0, 0); // {행, 열, 이동횟수, 먹은사과개수}

        System.out.print(min_move);
    }

    static void bt(int r, int c, int count, int apple) {
        check[r][c] = true; // 방문 여부 기록

        // 효율 높이기 위해 체크
        // 재귀 하다가 이미 최소 이동을 넘었을 때 그만하기
        if(min_move != -1 && count > min_move) return;

        if(board[r][c].equals("1")) { // 사과 만난 경우
            apple++;
        }

        if(apple >= 3) { // 먹은 사과 개수가 3개가 됐을 때 이동 횟수 최소인지 판별
            // 첫 경우의 수면 일단 기록, 아니면 비교해서 적은 횟수로 기록
            if(min_move == -1 || (min_move != -1 && min_move > count)) {
                min_move = count;
            }
            return; // 재귀 끝내기
        }

        for(int i=0; i<4; i++) { // 이동 경우의 수가 상하좌우로 4개라서 4번 반복
            int nr = r + moves[i][0]; // 이동한 뒤의 행
            int nc = c + moves[i][1]; // 이동한 뒤의 열

            // 보드판 나갔는지, 장애물 만났는지 체크
            // 만약 해당되면 그 경우의 수는 세지 않으므로 continue
            if(nr<0 || nr>=5 || nc<0 || nc>=5 || board[nr][nc].equals("-1")) {
                continue;
            }

            // 방문 여부 확인
            if(!check[nr][nc]) {
                // 재귀 ㄱㄱ
                bt(nr, nc, count+1, apple);
                // 다른 곳의 하위로 얘가 방문할 수도 있으니까
                // false로 바꿔줌
                check[nr][nc] = false;
            }
        }
    }
}