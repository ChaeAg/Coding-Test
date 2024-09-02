import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        set.add("ChongChong");

        for(int i=0; i<N; i++) {
            String[] str = br.readLine().split(" ");
            if(set.contains(str[0])) {
               set.add(str[1]);
            }
            else if(set.contains(str[1])) {
                set.add(str[0]);
            }
        }

        System.out.print(set.size());
    }
}