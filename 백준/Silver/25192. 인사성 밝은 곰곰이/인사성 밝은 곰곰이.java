import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> person = new HashSet<>();
        int count = 0;

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            if(str.equals("ENTER")) {
                count += person.size();
                person.clear();
                continue;
            }
            person.add(str);
        }

        System.out.print(count + person.size());
    }
}