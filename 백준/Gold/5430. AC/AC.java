import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            Deque<String> deque = new ArrayDeque<>();
            String p = br.readLine(); // D: 첫번째 수 버리기, R:배열 순서 거꾸로
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine().replace("[", "").replace("]", ""), ",");

            for(int k=0; k<n; k++) {
                deque.add(st.nextToken());
            }

            boolean isError = false;
            boolean front_start = true;
            for(String s : p.split("")) {
                if(s.equals("D")) {
                    if(deque.isEmpty()) {
                        isError = true;
                        break;
                    }

                    if(front_start) {
                        deque.removeFirst();
                    }
                    else {
                        deque.removeLast();
                    }
                }
                else {
                    front_start = !front_start;
                }
            }

            if(isError) {
                sb.append("error\n");
            }
            else {
                int len = deque.size();
                if(len == 0) {
                    sb.append("[");
                }
                else if(front_start) {
                    sb.append("[").append(deque.pollFirst());
                    for(int k=1; k<len; k++) {
                        sb.append(",").append(deque.pollFirst());
                    }
                }
                else {
                    sb.append("[").append(deque.pollLast());
                    for(int k=1; k<len; k++) {
                        sb.append(",").append(deque.pollLast());
                    }
                }
                sb.append("]\n");
            }
        }

        System.out.print(sb);
    }
}