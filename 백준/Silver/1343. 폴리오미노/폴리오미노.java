import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String result = "";
        String[] board = str.split("\\.");

        if(board.length == 0 && !str.contains(".")) {
            board = new String[]{str};
        }

        for(int i=0; i<board.length; i++) {
            int len = board[i].length();
            if(len % 2 != 0) { // 못바꾸는 경우 끝
                result = "-1";
                break;
            }

            int a = len / 2; // 홀수면 "BB"가 무조건 한 번 포함, 짝수면 "AAAA"로 다 가능

            if(a % 2 == 0) {
                board[i] = "AAAA".repeat(a/2);
            }
            else {
                board[i] = "AAAA".repeat(a/2) + "BB";
            }
        }

        if(!result.equals("-1")) {
            result = String.join(".", board);
            result += ".".repeat(str.length() - result.length());
        }

        System.out.print(result);
    }
}