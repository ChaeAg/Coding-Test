import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int[] nums;
    static int M, N;
    static Set<List<Integer>> results = new HashSet<>();

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

        List<List<Integer>> sortedList = new ArrayList<>(results);
        sortedList.sort((a, b) -> {
            for (int i = 0; i < M; i++) {
                int cmp = a.get(i).compareTo(b.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return a.size() - b.size();
        });

        StringBuilder sb = new StringBuilder();

        for (List<Integer> list : sortedList) {
            if (sb.length() > 0) {
                sb.append("\n");
            }

            for (int i = 0; i < M; i++) {
                if (i != 0) {
                    sb.append(" ");
                }
                sb.append(list.get(i));
            }
        }

        System.out.print(sb);
    }

    static void dfs(List<Integer> list) {
        if (list.size() == M) {
            results.add(list.stream().map(i -> nums[i]).collect(Collectors.toList()));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (list.contains(i)) {
                continue;
            }

            list.add(i);
            dfs(list);
            list.remove(Integer.valueOf(i));
        }
    }
}