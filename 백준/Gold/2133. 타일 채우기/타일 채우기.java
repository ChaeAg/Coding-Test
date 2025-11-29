import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // N이 홀수면 절대 못 채움
        if (N % 2 != 0) {
            System.out.println(0);
            return;
        }

        long[] non_over = new long[N + 1];
        long[] over_top = new long[N + 1]; // 맨 위만 튀어나옴
        long[] over_bot = new long[N + 1]; // 맨 아래만 튀어나옴

        // 초기값 설정
        non_over[0] = 1; // 0칸을 채우는 경우의 수는 1 (아무것도 안 함)
        non_over[1] = 0; // 홀수는 0

        // over 초기값 (N=1일 때)
        // 꽉 찬 상태(0)에서 -> 위만 튀어나오게 하려면: 맨위 가로, 아래 둘 세로 (1가지)
        over_top[1] = 1;
        over_bot[1] = 1;

        for (int i = 2; i <= N; i++) {
            // 1. 꽉 채우는 경우
            // (i-2에서 3줄 눕히기) + (위 튀어나온거 마감) + (아래 튀어나온거 마감)
            non_over[i] = non_over[i - 2] + over_top[i - 1] + over_bot[i - 1];

            // 2. 위만 튀어나오는 경우
            // (i-1 꽉 찬거에서 위 찌르기) + (i-2 위 튀어나온거 연장하기)
            over_top[i] = non_over[i - 1] + over_top[i - 2];

            // 3. 아래만 튀어나오는 경우 (위와 대칭)
            over_bot[i] = non_over[i - 1] + over_bot[i - 2];
        }

        System.out.println(non_over[N]);
    }
}