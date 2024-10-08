import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int scenarios = 1;
        int n = Integer.parseInt(br.readLine());

        while(n != 0) {
            String[] students = new String[n];
            List<String> memory = new ArrayList<>();

            for(int i=0; i<n; i++) {
                students[i] = br.readLine();
            }

            for(int i=0; i<2*n-1; i++) {
                String idx = br.readLine().split(" ")[0];
                if(memory.contains(idx)) memory.remove(idx);
                else memory.add(idx);
            }

            sb.append(scenarios).append(" ").append(students[Integer.parseInt(memory.get(0))-1]).append("\n");

            n = Integer.parseInt(br.readLine());
            scenarios++;
        }

        System.out.print(sb);
    }
}