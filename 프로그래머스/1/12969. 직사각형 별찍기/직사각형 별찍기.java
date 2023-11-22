import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        for(int i = 1; i<=a*b; i++) {
            sb.append("*");
            if(i % a == 0) sb.append("\n");
        }

        System.out.print(sb);
    }
}