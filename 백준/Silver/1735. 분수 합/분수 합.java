import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] first = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] second = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] maxArr = first[1] > second[1] ? first : second;
        int[] minArr = first[1] > second[1] ? second : first;

        int[] result = new int[2];
        List<Integer> temp = new ArrayList<>();

        for(int i=1; i<=maxArr[1]; i++) {
            temp.add(maxArr[1] * i);
            if(temp.contains(minArr[1] * i)) {
                result[0] = minArr[1]*i/maxArr[1]*maxArr[0] + minArr[0]*i;
                result[1] = minArr[1]*i;
                break;
            }
        }

        for(int i=Math.min(result[0], result[1]); i>=2; i--) {
            if(result[0] % i == 0 && result[1] % i == 0) {
                result[0] /= i;
                result[1] /= i;
            }
        }

        System.out.print(result[0] + " " + result[1]);
    }
}