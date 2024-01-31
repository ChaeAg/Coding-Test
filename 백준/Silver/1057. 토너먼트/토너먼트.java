import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int kim = Integer.parseInt(arr[1]);
        int im = Integer.parseInt(arr[2]);
        int result = -1;
        int round = 0;

        while(round <= N / 2) {
            round++;
            if(kim < im && (im - kim == 1 && kim % 2 == 1)) {
                result = round;
                break;
            }
            else if(kim - im == 1 && im % 2 == 1) {
                result = round;
                break;
            }
            kim = kim % 2 + kim / 2;
            im = im % 2 + im / 2;
        }

        System.out.print(result);
    }
}