import java.io.*;
import java.util.*;

public class Main {
    static int[] nums;
    static int M, N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        dfs(new ArrayList<>());

        System.out.print(sb);
    }

    static void dfs(List<Integer> list) {
        if (list.size() == M) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            for (int i = 0; i < M; i++) {
                if (i != 0) {
                    sb.append(" ");
                }
                sb.append(list.get(i));
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (list.contains(nums[i])) {
                continue;
            }

            list.add(nums[i]);
            dfs(list);
            list.remove(Integer.valueOf(nums[i]));
        }
    }
}