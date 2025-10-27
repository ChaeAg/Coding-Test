import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split("");
        int sum = 0;
        String num = "";
        boolean cond = false;

        for (String s : str) {
            if (s.equals("-") || s.equals("+")) {
                if (cond) {
                    sum -= Integer.parseInt(num);
                } else {
                    sum += Integer.parseInt(num);
                }

                if (s.equals("-") && !cond) cond = true;
                num = "";
            } else {
                num += s;
            }
        }

        if (cond) {
            sum -= Integer.parseInt(num);
        } else {
            sum += Integer.parseInt(num);
        }

        System.out.print(sum);
    }
}