import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] array = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        PriorityQueue<int[]> q = new PriorityQueue<>(((o1, o2) -> o2[0] - o1[0]));

        for (int i = 0; i < N - 1; i++) {
            q.add(new int[]{array[i + 1] - array[i], i}); // 차이가 큰 순으로 내림차순
        }

        int[] partitions = new int[K - 1]; // 차이가 제일 큰 곳부터 다른 조로 쪼개기 위한 파티션 인덱스를 구함.

        for (int i = 0; i < K - 1; i++) {
            partitions[i] = q.poll()[1];
        }

        Arrays.sort(partitions);

        int start = array[0];
        int result = 0;
        for (int i = 0; i < K; i++) {
            if (i == K - 1) { // 마지막일 경우 분기처리
                result += array[N - 1] - start;
                break;
            }
            result += (array[partitions[i]] - start);
            start = array[partitions[i] + 1];
        }

        System.out.print(result);
    }
}