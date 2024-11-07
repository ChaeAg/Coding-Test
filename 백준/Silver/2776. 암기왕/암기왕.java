import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] note = new int[N]; 
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                note[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(note); // 오름차순 정렬
            
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            
            for(int i=0; i<M; i++) {
                int num = Integer.parseInt(st.nextToken());
                boolean isContain = false;
                int front = 0, back = N-1, mid;
                
                while(front <= back) {
                    mid = (front + back) / 2;
                    
                    if(note[mid] == num) {
                        isContain = true;
                        break;
                    }
                    else if(note[mid] > num) {
                         back = mid - 1;
                    }
                    else {
                        front = mid + 1;
                    }
                }
                sb.append(isContain ? 1 : 0).append("\n");
            }
        }

        System.out.print(sb);
    }
}