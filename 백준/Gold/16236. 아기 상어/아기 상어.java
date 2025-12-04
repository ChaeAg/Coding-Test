import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] weight = {2, 0};
    static int time = 0;

    /**
     * 조건 1. 자신보다 무게가 적은 물고기만 먹을 수 있다. 2. 자신과 같은 무게의 물고기가 있는 칸은 지나갈 수 있다. 3. 자신의 무게와 같은 수의 물고기를 먹을 때마다 무게가 1씩
     * 증가한다.(무게=2, 물고기 2마리 먹으면 무게 3으로 up) 4. 이동은 상,하,좌,우 대신 먹을 수 있는 물고기 중 가장 가까운 물고기를 먹으러 간다. (최소비용으로) 5. 거리가 같은 물고기가
     * 많으면 가장 위 -> 가장 왼쪽 물고기를 고른다. 6. 더 이상 먹을 수 있는 물고기가 없다면 종료
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int nowShark_x = -1, nowShark_y = -1;

        /**
         * 공간 값 세팅
         * 처음 상어 위치, 물고기 위치 구하기
         */
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num != 0) {
                    if (num == 9) {
                        nowShark_x = i;
                        nowShark_y = j;
                        map[i][j] = 0;
                    } else {
                        map[i][j] = num;
                    }
                }
            }
        }

        bfs(nowShark_x, nowShark_y, map, N);

        System.out.print(time);
    }

    static void bfs(int nowShark_x, int nowShark_y, int[][] map, int N) {
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        q.add(new int[]{nowShark_x, nowShark_y, 0});
        visited[nowShark_x][nowShark_y] = true;

        PriorityQueue<int[]> temp = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        while (!q.isEmpty()) {
            temp.clear();

            while (!q.isEmpty()) {
                int[] nowShark = q.poll();

                for (int[] move : moves) {
                    int next_x = nowShark[0] + move[0];
                    int next_y = nowShark[1] + move[1];
                    int next_distance = nowShark[2] + 1;

                    if (next_x < 0 || next_x >= N || next_y < 0 || next_y >= N || visited[next_x][next_y]) {
                        continue;
                    }
                    if (map[next_x][next_y] > weight[0]) {
                        continue;
                    }

                    temp.add(new int[]{next_x, next_y, next_distance});
                    visited[next_x][next_y] = true;
                }
            }

            while (!temp.isEmpty()) {
                int[] tem = temp.poll();
                int next_x = tem[0];
                int next_y = tem[1];
                int next_distance = tem[2];

                if (map[next_x][next_y] != 0 && map[next_x][next_y] < weight[0]) { // 물고기 먹을 수 있음
                    weight[1]++;
                    if (weight[1] == weight[0]) {
                        weight[0]++;
                        weight[1] = 0;
                    }
                    time += next_distance;

                    // 먹은 순간 다시 거리 계산과 방문 체크 초기화!
                    q.clear();
                    visited = new boolean[N][N];

                    q.add(new int[]{next_x, next_y, 0});
                    visited[next_x][next_y] = true;

                    map[next_x][next_y] = 0;
                    break;
                }

                q.add(new int[]{next_x, next_y, next_distance});
            }
        }
    }
}