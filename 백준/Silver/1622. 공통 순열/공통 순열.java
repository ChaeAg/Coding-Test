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
        String s1;
        while((s1 = br.readLine()) != null) {
            String s2 = br.readLine();
            if(s1.length() < s2.length()) {
                String tmp = s1;
                s1 = s2;
                s2 = tmp;
            }
            List<String> result = new ArrayList<>();
            for(int i=0; i<s1.length(); i++) {
                String s = s1.substring(i, i+1);
                if(s2.contains(s)) {
                    result.add(s);
                    s2 = s2.replaceFirst(s, "");
                }
            }
            result.sort(Comparator.naturalOrder());
            sb.append(String.join("", result)).append("\n");
        }
        System.out.print(sb);
    }
}