import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plus_q = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minus_q = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n > 0) {
                plus_q.add(n);
            } else {
                minus_q.add(n);
            }
        }

        int sum = 0;
        while (plus_q.size() > 1) {
            int num1 = plus_q.poll();
            int num2 = plus_q.poll();

            if (num1 == 1 || num2 == 1) {
                sum += num1;
                sum += num2;
            } else {
                sum += num1 * num2;
            }
        }

        while (minus_q.size() > 1) {
            sum += minus_q.poll() * minus_q.poll();
        }

        if (!plus_q.isEmpty()) {
            sum += plus_q.poll();
        }
        if (!minus_q.isEmpty()) {
            sum += minus_q.poll();
        }
        System.out.print(sum);
    }
}