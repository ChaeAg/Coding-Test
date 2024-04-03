import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int count1 = 0, count2 = 0;
        for(String s : S.split("0")) {
            if(!s.isEmpty()) count1++;
        }
        for(String s : S.split("1")) {
            if(!s.isEmpty()) count2++;
        }

        if (count1 == 0 && count2 == 0) {
            System.out.print(0);
        }
        else if (count1 > count2) {
            System.out.print(count2);
        } else {
            System.out.print(count1);
        }
    }
}