import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int minCount = Math.abs(N - 100);

        if(N == 100) {
            System.out.print(0);
        }
        else {
            int M = Integer.parseInt(br.readLine());
            List<String> crash = new ArrayList<>();

            if(M != 0) {
                crash = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toList());
            }

            for (int i=0; i<1000000; i++) { // 0 ~ 999999
                String num = String.valueOf(i);

                boolean isFail = false;
                for (int j=0; j<num.length(); j++) {
                    if (crash.contains(String.valueOf(num.charAt(j)))) { // 고장난 버튼을 눌러야햠
                        isFail = true;
                        break;
                    }
                }

                if (!isFail) {
                    int count = Math.abs(N - i) + num.length();
                    minCount = count < minCount ? count : minCount;
                }
            }

            System.out.print(minCount);
        }
    }
}