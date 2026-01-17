import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] seq = new int[N + 1];

        Set<Integer>[] childs = new HashSet[N + 1];
        for (int i = 0; i <= N; i++) {
            childs[i] = new HashSet<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            List<Integer> temp = new ArrayList<>();
            for (int k = 0; k < cnt; k++) {
                temp.add(Integer.parseInt(st.nextToken()));
            }

            for (int k = 0; k < cnt - 1; k++) {
                int from = temp.get(k);
                for (int j = k + 1; j < cnt; j++) {
                    int to = temp.get(j);
                    if (childs[from].add(to)) {
                        seq[to]++;
                    }
                }
            }
        }

        Queue<Integer> que = new ArrayDeque<>();
        for (int singer = 1; singer <= N; singer++) {
            if (seq[singer] == 0) {
                que.add(singer);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!que.isEmpty()) {
            int singer = que.poll();
            result.add(singer);

            for (int child : childs[singer]) {
                seq[child]--;
                if (seq[child] == 0) {
                    que.add(child);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (result.size() < N) {
            sb.append(0);
        } else {
            for (int i : result) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }
}