import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NandM = br.readLine().split(" ");
        int N = Integer.parseInt(NandM[0]);
        int M = Integer.parseInt(NandM[1]);
        int[][] store = new int[M][2];
        int minSet = 1000;
        int minEach = 1000;
        for(int i=0; i<M; i++) {
            store[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            if(minSet > store[i][0]) minSet = store[i][0]; // 브랜드중에 세트 가격이 제일 싼 곳을 찾음
            if(minEach > store[i][1]) minEach = store[i][1]; // 브랜드중에 낱개 가격이 제일 싼 곳을 찾음
        }
        if(minEach * 6 <= minSet) System.out.print(N * minEach); // 낱개로 모두 사는게 제일 싼 경우
        else if(((N / 6) + 1) * minSet <= (N / 6) * minSet + (N % 6) * minEach) System.out.print(((N / 6) + 1) * minSet); // 세트로 모두 사는게 제일 싼 경우
        else { // 제일 싼 세트로 사고 남은건 제일 싼 낱개로 사는 경우
            int money = 0;
            money += (N / 6) * minSet;
            money += (N % 6) * minEach;
            System.out.print(money);
        }
    }
}