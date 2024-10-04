import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = N;

        for(int i=0; i<N; i++) {
            String[] str = br.readLine().split("");
            List<String> words = new ArrayList<>();
            words.add(str[0]);
            for(int j=1; j<str.length; j++) {
                if(str[j].equals(str[j-1])) {
                    continue;
                }
                if(words.contains(str[j])) {
                    count--;
                    break;
                }
                words.add(str[j]);
            }
        }

        System.out.print(count);
    }
}