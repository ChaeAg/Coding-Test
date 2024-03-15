import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> strs = new Stack();
        for(char c : s.toCharArray()) {
            if(!strs.empty() && strs.peek() == c) strs.pop();
            else strs.push(c);
        }
        return strs.empty() ? 1 : 0;
    }
}