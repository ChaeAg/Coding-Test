import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int[][] schedules;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        schedules = new int[N][2];

        for(int i=0; i<N; i++) {
            String[] temp = br.readLine().split(" ");
            schedules[i][0] = Integer.parseInt(temp[0]);
            schedules[i][1] = Integer.parseInt(temp[1]);
        }
        int[] money = new int[N+1];
        dp(money);
        System.out.print(money[N]);
    }

    static void dp(int[] money) {
        for(int i=0; i<N; i++) {
            int nextDay = i + schedules[i][0];

            if(nextDay <= N) {
                if(money[nextDay] < money[i] + schedules[i][1]) {
                    money[nextDay] = money[i] + schedules[i][1];
                }
            }
            
            if(money[i+1] < money[i]) money[i+1] = money[i];
        }
    }
}