import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] lines = new int[N][2];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken()); // 시작점
            lines[i][1] = Integer.parseInt(st.nextToken()); // 끝점
        }

        Arrays.sort(lines, (o1, o2) -> { // 시작점 기준 오름차순 정렬 (같으면 끝점 내림차순)
            if(o1[0] == o2[0]) return o2[1] - o1[1];
            return o1[0] - o2[0];
        });

        int[][] now = new int[N][2];
        now[0] = lines[0];
        int index = 0, len = lines[0][1] - lines[0][0];
        for(int i=1; i<N; i++) {
             if(lines[i][0] > now[index][1]) { // 새로운 선 생김
                 index++;
                 now[index] = lines[i];
                 len += lines[i][1] - lines[i][0];
             }
             else if(lines[i][1] > now[index][1]) { // 기존 선에 포함되거나, 끝이 더 길수도
                 len += lines[i][1] - now[index][1];
                 now[index][1] = lines[i][1];
             }
        }

        System.out.print(len);
    }
}