import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int N = Integer.parseInt(br.readLine());
                List<Integer> list = new ArrayList<>();
                for(int i=0; i<N; i++) {
                        list.add(Integer.parseInt(br.readLine()));
                }
                list.sort(Comparator.reverseOrder());
                Long tip = 0L;
                for(int i=0; i<list.size(); i++) {
                        if(list.get(i) - (i+1 -1) <= 0) break;
                        tip += list.get(i) - (i+1 -1);
                }
                System.out.print(tip);
        }
}