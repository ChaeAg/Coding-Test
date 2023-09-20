import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int data = 1, popcount = 0, num;

        Stack<Integer> stack = new Stack<>(); //int형 스택 선언
        List<String> result = new ArrayList<>();
        
        while(popcount != n) {
            num = sc.nextInt();            
            if(!stack.empty()){
                if(stack.peek() < num){
                    while(stack.peek() != num){
                        stack.push(data);
                        data++;
                        result.add("+");
                    }
                }
                else if(stack.peek() > num){
                    System.out.println("NO");
                    System.exit(0);
                }
            }
            else{
                if(data <= num) {
                    while(data <= num){
                        stack.push(data);
                        data++;
                        result.add("+");
                    }
                }
                else {
                    System.out.println("NO");
                    System.exit(0);
                }   
            }
            if(stack.peek() == num){
                stack.pop();
                result.add("-");
                popcount++;
            }
        }
        for(String s:result) System.out.println(s);
    }
}
