import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split("");
        String[] target = br.readLine().split("");
        int len = target.length;

        Stack<String> stack = new Stack<>();

        for(int i=0; i<strs.length; i++) {
            Stack<String> tempStack = new Stack<>(); // 현재 비교중인 문자들 저장하는 용도
            stack.add(strs[i]);
            if(stack.size() >= len && strs[i].equals(target[len-1])) { // 지금 들어온 문자가 목표 문자얼의 마지막 문자랑 같다면
                tempStack.add(stack.pop());
                boolean isSame = true;
                for(int j=2; j<=len; j++) { // 목표 문자열 길이만큼 비교. 마지막 문자는 위에서 비교 했으니 그 다음부터
                    String s = stack.pop();
                    tempStack.add(s); // 하나라도 목표 문자랑 다를경우 넣은 것들을 다시 스택에 넣을 수 있도록 임시로 저장
                    if(!s.equals(target[len-j])) {
                        isSame = false;
                        break;
                    }
                }
                if(!isSame) { // 목표 문자열이랑 같지 않았다면 빼서 큐에 저장해뒀던거 그대로 다시 넣음
                    int size = tempStack.size();
                    for(int j=0; j<size; j++) {
                        stack.add(tempStack.pop());
                    }
                }
            }
        }

        System.out.print(stack.isEmpty() ? "FRULA" : String.join("", stack).replaceAll(String.join("", target), ""));
    }
}