import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Set<String> cmd_set = new HashSet<>();

        while (N-- > 0) {
            String input = br.readLine();
            String[] str = input.split(" ");
            int cmd_idx = -1;
            int idx_gauge = 0;

            for (int i = 0; i < str.length; i++) {
                String first_s = str[i].substring(0, 1).toUpperCase();
                if (!cmd_set.contains(first_s)) {
                    cmd_set.add(first_s);
                    cmd_idx = idx_gauge;

                    if (i != 0) {
                        sb.append(input, 0, cmd_idx);
                    }
                    break;
                } else {
                    idx_gauge += str[i].length() + 1;
                }
            }

            if (cmd_idx != -1) {
                sb.append("[").append(input.charAt(cmd_idx))
                        .append("]").append(input.substring(cmd_idx + 1)).append("\n");
                continue;
            }

            String[] arr = input.split("");
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equals(" ")) {
                    sb.append(" ");
                    continue;
                }
                if (!cmd_set.contains(arr[i].toUpperCase())) {
                    cmd_set.add(arr[i].toUpperCase());
                    sb.append("[").append(arr[i]).append("]");

                    for (int k = i + 1; k < arr.length; k++) {
                        sb.append(arr[k]);
                    }

                    break;
                } else {
                    sb.append(arr[i]);
                }
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}