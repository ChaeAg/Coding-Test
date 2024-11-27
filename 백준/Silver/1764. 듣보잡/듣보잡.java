import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Boolean> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            map.put(br.readLine(), true);
        }

        int count = 0;
        List<String> names = new ArrayList<>();
        for(int i=0; i<M; i++) {
            String name = br.readLine();
            if (map.getOrDefault(name, false)) {
                count++;
                names.add(name);
            }
        }

        names.sort(Comparator.naturalOrder());
        System.out.println(count + "\n" + String.join("\n", names));
    }
}