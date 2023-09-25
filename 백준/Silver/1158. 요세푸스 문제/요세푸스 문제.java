import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        int listidx = 0;

        for(int i=1; i<=N; i++) list.add(i);

        sb.append("<");
        while(!list.isEmpty()) {
            if(listidx + K <= list.size()){
                listidx = listidx + K -1;
            } 
            else {
                listidx = (listidx + K - 1) % list.size();
            }
            if(list.size() == 1) sb.append(list.get(listidx)).append(">");
            else sb.append(list.get(listidx)).append(", ");
            list.remove(listidx);
        }

        System.out.println(sb);
    }
}
