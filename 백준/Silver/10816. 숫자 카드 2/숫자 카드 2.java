import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringBuilder sb = new StringBuilder();
                StringTokenizer st;
                Map<Integer, Integer> map = new HashMap();
                
                int N = Integer.parseInt(br.readLine());
                st = new StringTokenizer(br.readLine());
                for(int i=0; i<N; i++) {
                        int number = Integer.parseInt(st.nextToken());
                        map.put(number, map.getOrDefault(number,0) + 1);
                }
                
                int M = Integer.parseInt(br.readLine());
                st = new StringTokenizer(br.readLine());
                for(int i=0; i<M; i++) {
                        int number = Integer.parseInt(st.nextToken());
                        sb.append(map.getOrDefault(number, 0)).append(" ");
                }
                System.out.print(sb);
        }
}