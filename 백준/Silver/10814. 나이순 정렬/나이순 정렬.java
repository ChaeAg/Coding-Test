import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[][] users = new String[N][2];
        for(int i=0; i<N; i++) {
            users[i] = br.readLine().split(" ");
        }

        Arrays.sort(users, new Comparator<String[]>() {
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        for(String[] user : users) {
            sb.append(user[0]).append(" ").append(user[1]).append("\n");
        }

        System.out.print(sb);
    }
}