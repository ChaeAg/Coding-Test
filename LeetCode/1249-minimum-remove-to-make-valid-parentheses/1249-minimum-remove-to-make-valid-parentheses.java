import java.util.*;
class Solution {
    public String minRemoveToMakeValid(String s) {
        String[] strs = s.split("");

        int openCnt = 0;
        Stack<Integer> openIdxStack = new Stack<>();
        for(int i=0; i<strs.length; i++) {
            if(strs[i].equals("(")) {
                openCnt++;
                openIdxStack.push(i);
            }
            else if(strs[i].equals(")")) {
                if(openCnt == 0) {
                    strs[i] = "";
                } else {
                    openCnt--;
                    openIdxStack.pop();
                }
            }
        }

        while(!openIdxStack.isEmpty()) {
            strs[openIdxStack.pop()] = "";
        }

        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            if(!str.isEmpty()) sb.append(str);
        }
        return sb.toString();
    }
}