import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>(); // 명소 인덱스 저장
        int[] arr = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 1) set.add(i);
        }

        int now = 1;
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("3")) {
                if (set.isEmpty()) {
                    sb.append(-1).append("\n");
                    continue;
                }

                Integer big_spot = set.ceiling(now);
                Integer small_spot = set.first();
                int min_dis_spot;

                if (big_spot == null) {
                    min_dis_spot = N - now + small_spot;
                } else if (small_spot == null) {
                    min_dis_spot = big_spot - now;
                } else {
                    if (big_spot - now > N - now - 1 + small_spot) {
                        min_dis_spot = N - now - 1 + small_spot;
                    } else {
                        min_dis_spot = big_spot - now;
                    }
                }
                sb.append(min_dis_spot).append("\n");
            } else if (cmd.equals("2")) {
                now = ((now - 1 + Integer.parseInt(st.nextToken())) % N) + 1;
            } else {
                int i = Integer.parseInt(st.nextToken());
                arr[i] = arr[i] == 1 ? 0 : 1;
                if (arr[i] == 1) set.add(i);
                else set.remove(i);
            }
        }

        System.out.print(sb);
    }
}