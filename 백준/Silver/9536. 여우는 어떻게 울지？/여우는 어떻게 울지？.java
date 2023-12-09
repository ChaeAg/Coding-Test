import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int T = Integer.parseInt(br.readLine());

                for(int i=0; i<T; i++) {
                        List<String> list = new ArrayList<>(List.of(br.readLine().split(" ")));
                        while(true) {
                                String line = br.readLine();
                                if(line.equals("what does the fox say?")) {
                                        list.forEach(str -> System.out.print(str + " "));
                                        break;
                                }
                                while(list.contains(line.split(" ")[2])) {
                                        list.remove(line.split(" ")[2]);
                                }
                        }
                }
        }
}