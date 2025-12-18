import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(0, new ArrayList<>(), 1);

        System.out.print(sb);
    }

    static void dfs(int dept, List<Integer> list, int num) {
        if (dept == M) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i < list.size() - 1) {
                    sb.append(" ");
                }
            }
            return;
        }

        for (int i = num; i <= N; i++) {
            list.add(i);
            dfs(dept + 1, list, i);
            list.remove(list.size() - 1);
        }
    }
}