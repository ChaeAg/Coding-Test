import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String[] str = br.readLine().split("");

        int cnt = 0;
        Queue<Integer> burger_q = new LinkedList<>();
        Queue<Integer> person_q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            if (str[i].equals("H")) {
                boolean is_connect = false;
                while (!person_q.isEmpty()) {
                    if (i - person_q.poll() <= K) {
                        cnt++;
                        is_connect = true;
                        break;
                    }
                }
                if (!is_connect) {
                    burger_q.add(i);
                }
            } else {
                if (burger_q.isEmpty()) {
                    person_q.add(i);
                    continue;
                }

                while (!burger_q.isEmpty()) {
                    if (i - burger_q.poll() <= K) { // 먹을 수 있는 버거 중 가장 작은 인덱스 버거를 먹음!
                        cnt++;
                        break;
                    }
                }
            }
        }

        while (!burger_q.isEmpty() && !person_q.isEmpty()) {
            int p_idx = person_q.poll();
            while (!burger_q.isEmpty()) {
                if (p_idx - burger_q.poll() <= K) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.print(cnt);
    }
}