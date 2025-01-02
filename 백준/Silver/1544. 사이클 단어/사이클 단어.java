import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strs = new String[N];

        for (int i = 0; i < N; i++) {
            strs[i] = br.readLine();
        }

        int count = N;

        for (int i = 0; i < N; i++) {
            String[] str1 = strs[i].split("");
            for (int j = i + 1; j < N; j++) {
                boolean is_done = false;
                List<String> str2 = Arrays.stream(strs[j].split("")).collect(Collectors.toList());
                int size = str2.size();

                if (str1.length != size || !str2.contains(str1[0])) {
                    continue;
                }

                for (int k = 0; k < size; k++) {
                    boolean is_same = true;
                    if (str1[0].equals(str2.get(k))) {
                        for (int l = 1; l < size; l++) {
                            if (!str1[l].equals(str2.get((k + l) % size))) {
                                is_same = false;
                                break;
                            }
                        }
                    } else {
                        continue;
                    }

                    if (is_same) {
                        count--;
                        is_done = true;
                        break;
                    }
                }

                if (is_done) {
                    break;
                }
            }
        }

        System.out.print(count);
    }
}