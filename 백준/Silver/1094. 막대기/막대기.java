import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        List<Integer> bars = new ArrayList<>();
        bars.add(64);

        while(true) {
            int sum = bars.stream().mapToInt(i->i).sum();
            if(sum == X) break;
            int min = bars.stream().mapToInt(i->i).min().getAsInt();
            bars.remove(bars.indexOf(min));
            bars.add(min/2);

            if(sum - (min/2) < X) {
                bars.add(min/2);
            }
        }

        System.out.print(bars.size());
    }
}