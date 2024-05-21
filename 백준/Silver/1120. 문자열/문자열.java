import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int min = A.length();
        for(int idx=0; idx<=B.length()-A.length(); idx++) {
            int diff_count = 0;
            for(int i=0; i<A.length(); i++) {
                if(A.charAt(i) != B.charAt(i+idx)) {
                    diff_count++;
                }
            }
            if(diff_count < min) min = diff_count;
        }

        System.out.print(min);
    }
}
