import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int[][] move = {{0, 0, 1}, {0, 0, -1}, {0, 1, 0}, {0, -1, 0}, {-1, 0, 0}, {1, 0, 0}}; // 동, 서, 남, 북, 상, 하 순
    static StringBuilder sb = new StringBuilder();
    static String goal_message_format = "Escaped in %d minute(s).";
    static String fail_message = "Trapped!";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            String[][][] building = new String[L][R][C];
            int[] start_idx = new int[4];
            int[] target_idx = new int[3];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String[] str = br.readLine().split("");
                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = str[k];

                        if (building[i][j][k].equals("S")) {
                            start_idx[0] = i;
                            start_idx[1] = j;
                            start_idx[2] = k;
                            start_idx[3] = 0;
                        }
                        if (building[i][j][k].equals("E")) {
                            target_idx[0] = i;
                            target_idx[1] = j;
                            target_idx[2] = k;
                        }
                    }
                }
                br.readLine(); // 공백 한 줄 빼주기
            }

            bfs(start_idx, L, R, C, building, target_idx);
        }

        System.out.print(sb);
    }

    static public void bfs(int[] start_idx, int L, int R, int C, String[][][] building, int[] target_idx) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start_idx);

        boolean[][][] visited = new boolean[L][R][C];
        visited[start_idx[0]][start_idx[1]][start_idx[2]] = true;

        int goal_seconds = 0;

        while (!queue.isEmpty()) {
            int[] now_idx = queue.poll();

            for (int[] m : move) {
                int next_L = now_idx[0] + m[0];
                int next_R = now_idx[1] + m[1];
                int next_C = now_idx[2] + m[2];
                int next_seconds = now_idx[3] + 1;

                if (target_idx[0] == next_L && target_idx[1] == next_R && target_idx[2] == next_C) {
                    goal_seconds = next_seconds;
                    queue.clear();
                    break;
                }

                if (next_L < 0 || next_L >= L
                        || next_R < 0 || next_R >= R
                        || next_C < 0 || next_C >= C
                        || building[next_L][next_R][next_C].equals("#")
                        || visited[next_L][next_R][next_C]
                ) {
                    continue;
                }

                visited[next_L][next_R][next_C] = true;
                queue.add(new int[]{next_L, next_R, next_C, next_seconds});
            }
        }

        sb.append(goal_seconds == 0 ? fail_message : String.format(goal_message_format, goal_seconds)).append("\n");
    }
}