import java.io.*;
import java.util.*;

public class Main {
    static List<Set<Integer>> connect_list = new ArrayList<>();
    static boolean[] know_checked;

    public static void main(String[] args) throws IOException {
        // 진실만 말해야되는 번호와 같은 파티에 한 번이라도 있는 사람 번호와 같이 있으면 진실을 말해야함.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int know_cnt = Integer.parseInt(st.nextToken());

        Set<Integer> know_set = new HashSet<>();

        for (int i = 0; i < know_cnt; i++) {
            know_set.add(Integer.parseInt(st.nextToken()));
        }

        connect_list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            connect_list.add(new HashSet<>());
        }

        List<List<Integer>> party = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            party.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int party_join_cnt = Integer.parseInt(st.nextToken());
            int[] p = new int[party_join_cnt];

            for (int j = 0; j < party_join_cnt; j++) {
                p[j] = Integer.parseInt(st.nextToken());
                party.get(i).add(p[j]);
            }

            for (int k1 = 0; k1 < party_join_cnt; k1++) {
                for (int k2 = k1; k2 < party_join_cnt; k2++) {
                    if (k1 == k2) {
                        continue;
                    }
                    connect_list.get(p[k1]).add(p[k2]);
                    connect_list.get(p[k2]).add(p[k1]);
                }
            }
        }

        know_checked = new boolean[N + 1];

        for (int i : know_set) {
            know_checked[i] = true;
        }

        for (int know_n : know_set) { // 전파
            dfs(know_n);
        }

        int answer = 0;

        for (int i = 0; i < M; i++) {
            boolean is_ok = true;
            for (int j : party.get(i)) {
                if (know_checked[j]) {
                    is_ok = false;
                    break;
                }
            }
            if (is_ok) {
                answer++;
            }
        }

        System.out.print(answer);
    }

    static void dfs(int n) {
        for (int i : connect_list.get(n)) {
            if (!know_checked[i]) {
                know_checked[i] = true;
                dfs(i);
            }
        }
    }
}