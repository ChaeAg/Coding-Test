import java.util.*;
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int asteroid : asteroids) {
            if(asteroid < 0) {
                boolean isWin = true;
                while(!stack.isEmpty() && stack.peek() > 0) {
                    if(stack.peek() < -asteroid) { // 현재 행성이 이김
                        stack.pop();
                    } else { // 현재 행성이 지거나 비김
                        if(stack.peek() == -asteroid) stack.pop(); // 비긴 경우
                        isWin = false;
                        break;
                    }
                }
                if(isWin) stack.push(asteroid);
                continue;
            }
            stack.push(asteroid);
        }

        int[] result = new int[stack.size()];
        for(int i=result.length-1; i>=0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}