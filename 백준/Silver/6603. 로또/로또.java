import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[] nums;
    static boolean[] visited;
    static int k;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;
            nums = new String[k];
            visited = new boolean[k];
            for(int i=0; i<k; i++) {
                nums[i] = st.nextToken();
            }
            zohab(0, 0);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void zohab(int start, int cnt) {
        if(cnt == 6) {
            for(int i=0; i<k; i++) {
                if(visited[i]) sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<k; i++) {
            if(!visited[i]) {
                visited[i] = true;
                zohab(i, cnt+1);
                visited[i] = false;
            }
        }
    }
}