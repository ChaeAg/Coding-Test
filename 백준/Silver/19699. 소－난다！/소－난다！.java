import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int N, M;
    static int[] weights;
    static boolean[] visited;
    static List<Integer> output = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        weights = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        visited = new boolean[N];
        zohab(0, 0);
        String result;
        if (output.isEmpty()) {
            result = "-1";
        }
        else {
            result = output.stream()
                    .sorted()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));
        }
        System.out.print(result);
    }

    static void zohab(int start, int cnt) {
        if(cnt == M) {
            int sum = 0;
            for(int i=0; i<N; i++) {
                if(visited[i]) sum += weights[i];
            }
            if(isSosu(sum) && !output.contains(sum)) output.add(sum);
        }

        for(int i=start; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                zohab(i, cnt + 1);
                visited[i] = false;
            }
        }
    }

    static boolean isSosu(int num) {
        for(int i=2; i*i<=num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}