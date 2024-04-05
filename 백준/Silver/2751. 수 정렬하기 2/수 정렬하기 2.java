import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<Integer> nums = new ArrayList<>();
        for(int i=0; i<N; i++) {
            nums.add(Integer.parseInt(br.readLine()));
        }
        nums.sort(Comparator.naturalOrder());

        for(int i=0; i<N; i++) {
            sb.append(nums.get(i)).append("\n");
        }

        System.out.print(sb);
    }
}