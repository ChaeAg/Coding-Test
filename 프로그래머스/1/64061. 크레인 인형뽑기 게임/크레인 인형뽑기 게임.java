import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack();
        
        for(int i=0; i<moves.length; i++) {
            int line = moves[i];
            for(int j=0; j<board.length; j++) {
                if(board[j][line-1] != 0) { // 인형이 있는 경우
                    // 바구니가 비어있거나 맨 상단 인형과 새로운 인형이 서로 다를 경우
                    if(basket.isEmpty() || basket.peek() != board[j][line-1]) {
                        basket.add(board[j][line-1]);
                    }
                    else if(basket.peek() == board[j][line-1]) { // 맨 상단 인형이 새로운 인형과 같은 인형인 경우
                        basket.pop();
                        answer += 2;
                    }
                    board[j][line-1] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
}