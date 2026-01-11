import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 보석 개수
        int K = Integer.parseInt(st.nextToken()); // 가방 개수

        long[][] jewels = new long[N][2]; // 무게, 가격 순
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long M = Integer.parseInt(st.nextToken());
            long V = Integer.parseInt(st.nextToken());

            jewels[i][0] = M;
            jewels[i][1] = V;
        }

        long[] bagLimits = new long[K];
        for (int i = 0; i < K; i++) {
            bagLimits[i] = Integer.parseInt(br.readLine()); // i번째 가방에 담을 수 있는 최대 무게
        }

        Arrays.sort(jewels, ((o1, o2) -> Math.toIntExact(o1[0] - o2[0])));

        Arrays.sort(bagLimits);

        long totalCost = 0;
        int lastJewelIdx = -1;
        PriorityQueue<long[]> costQue = new PriorityQueue<>(((o1, o2) -> Math.toIntExact(o2[1] - o1[1])));

        for (long bagLimit : bagLimits) {
            for (int i = lastJewelIdx + 1; i < N; i++) {
                if (bagLimit < jewels[i][0]) {
                    break;
                }

                costQue.add(jewels[i]);
                lastJewelIdx = i;
            }

            if (!costQue.isEmpty()) {
                totalCost += costQue.poll()[1];
            }
        }

        System.out.print(totalCost);
    }
}