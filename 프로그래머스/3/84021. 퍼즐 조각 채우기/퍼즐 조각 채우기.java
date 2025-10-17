// 10/17 전체적인 설계와 구현은 스스로 했지만 마지막 추출한 도형끼리의 비교 부분에서 GPT의 도움을 받음.
import java.util.*;

class Solution {
    int[][] game_board;
    int[][] table;
    int len;
    int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // 테이블: 면적 -> (조각 하나의 회전 4종 묶음) 리스트
    Map<Integer, List<List<boolean[][]>>> table_map = new HashMap<>();
    // 보드: 면적 -> 빈칸 모양 리스트(원본 1종, normalize 적용)
    Map<Integer, List<boolean[][]>> board_map = new HashMap<>();

    boolean[][] all_visited;

    public int solution(int[][] game_board, int[][] table) {
        this.len = game_board.length;
        this.game_board = game_board;
        this.table = table;
        this.all_visited = new boolean[len][len];

        // 1) 테이블: 조각 추출 -> 스케일(+패딩) -> 회전4종 -> normalize -> 묶음 저장
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (all_visited[i][j]) continue;
                if (table[i][j] == 1) {
                    boolean[][] now_shape = bfs_table(i, j);

                    int min_x = len, max_x = 0, min_y = len, max_y = 0;
                    int shape_count = 0;
                    for (int r = 0; r < len; r++) {
                        for (int c = 0; c < len; c++) {
                            if (!now_shape[r][c]) continue;
                            min_x = Math.min(min_x, r);
                            max_x = Math.max(max_x, r);
                            min_y = Math.min(min_y, c);
                            max_y = Math.max(max_y, c);
                            shape_count++;
                        }
                    }
                    int x_range = max_x - min_x + 1;
                    int y_range = max_y - min_y + 1;
                    int n_size = Math.max(x_range, y_range) + 2; // 패딩 1칸 유지

                    boolean[][] scale = new boolean[n_size][n_size];
                    for (int r = 1; r <= x_range; r++) {
                        for (int c = 1; c <= y_range; c++) {
                            if (now_shape[min_x + r - 1][min_y + c - 1]) {
                                scale[r][c] = true;
                            }
                        }
                    }

                    // 회전 4종 + normalize + 중복 제거
                    boolean[][] r0 = normalize(scale);
                    boolean[][] r1 = normalize(rotate90(scale, n_size));
                    boolean[][] r2 = normalize(rotate180(scale, n_size));
                    boolean[][] r3 = normalize(rotate270(scale, n_size));

                    Set<String> seen = new HashSet<>();
                    List<boolean[][]> variants = new ArrayList<>();
                    for (boolean[][] v : new boolean[][][]{r0, r1, r2, r3}) {
                        String sig = signature(v);
                        if (seen.add(sig)) variants.add(v);
                    }

                    List<List<boolean[][]>> tlist = table_map.getOrDefault(shape_count, new ArrayList<>());
                    tlist.add(variants);
                    table_map.put(shape_count, tlist);
                }
            }
        }

        // 2) 보드: 빈칸 추출 -> 스케일(+패딩) -> normalize
        all_visited = new boolean[len][len]; // 방문 초기화
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (all_visited[i][j]) continue;
                if (game_board[i][j] == 0) {
                    boolean[][] now_shape = bfs_board(i, j);

                    int min_x = len, max_x = 0, min_y = len, max_y = 0;
                    int shape_count = 0;
                    for (int r = 0; r < len; r++) {
                        for (int c = 0; c < len; c++) {
                            if (!now_shape[r][c]) continue;
                            min_x = Math.min(min_x, r);
                            max_x = Math.max(max_x, r);
                            min_y = Math.min(min_y, c);
                            max_y = Math.max(max_y, c);
                            shape_count++;
                        }
                    }
                    int x_range = max_x - min_x + 1;
                    int y_range = max_y - min_y + 1;
                    int n_size = Math.max(x_range, y_range) + 2;

                    boolean[][] scale = new boolean[n_size][n_size];
                    for (int r = 1; r <= x_range; r++) {
                        for (int c = 1; c <= y_range; c++) {
                            if (now_shape[min_x + r - 1][min_y + c - 1]) {
                                scale[r][c] = true;
                            }
                        }
                    }
                    scale = normalize(scale); // ★ 좌상단 정렬

                    List<boolean[][]> blist = board_map.getOrDefault(shape_count, new ArrayList<>());
                    blist.add(scale);
                    board_map.put(shape_count, blist);
                }
            }
        }

        // 3) 매칭 및 합산
        return matchAndCount();
    }

    // ----- BFS: 테이블 조각 -----
    private boolean[][] bfs_table(int i, int j) {
        boolean[][] visited = new boolean[len][len];
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        all_visited[i][j] = true;
        q.add(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] m : move) {
                int nr = cur[0] + m[0];
                int nc = cur[1] + m[1];
                if (nr < 0 || nr >= len || nc < 0 || nc >= len) continue;
                if (visited[nr][nc]) continue;
                if (table[nr][nc] == 0) continue;

                visited[nr][nc] = true;
                all_visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
        return visited;
    }

    // ----- BFS: 보드 빈칸 -----
    private boolean[][] bfs_board(int i, int j) {
        boolean[][] visited = new boolean[len][len];
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        all_visited[i][j] = true;
        q.add(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] m : move) {
                int nr = cur[0] + m[0];
                int nc = cur[1] + m[1];
                if (nr < 0 || nr >= len || nc < 0 || nc >= len) continue;
                if (visited[nr][nc]) continue;
                if (game_board[nr][nc] == 1) continue;

                visited[nr][nc] = true;
                all_visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
        return visited;
    }

    // ----- 회전 -----
    private boolean[][] rotate90(boolean[][] arr, int L) {
        boolean[][] rotated = new boolean[L][L];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                rotated[j][L - 1 - i] = arr[i][j];
            }
        }
        return rotated;
    }

    private boolean[][] rotate180(boolean[][] arr, int L) {
        boolean[][] rotated = new boolean[L][L];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                rotated[L - 1 - i][L - 1 - j] = arr[i][j];
            }
        }
        return rotated;
    }

    private boolean[][] rotate270(boolean[][] arr, int L) {
        boolean[][] rotated = new boolean[L][L];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                rotated[L - 1 - j][i] = arr[i][j];
            }
        }
        return rotated;
    }

    // ----- 좌상단 정렬(normalize) -----
    // 패딩 1칸 유지: (i - minR + 1, j - minC + 1)로 이동
    private boolean[][] normalize(boolean[][] a) {
        int L = a.length;
        int minR = L, minC = L;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                if (a[i][j]) {
                    if (i < minR) minR = i;
                    if (j < minC) minC = j;
                }
            }
        }
        if (minR == L) return a; // 모두 false

        boolean[][] n = new boolean[L][L];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                if (a[i][j]) {
                    n[i - minR + 1][j - minC + 1] = true;
                }
            }
        }
        return n;
    }

    // ----- 시그니처(중복 회전 제거용) -----
    private String signature(boolean[][] a) {
        int L = a.length;
        StringBuilder sb = new StringBuilder(L * (L + 1));
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) sb.append(a[i][j] ? '1' : '0');
            sb.append('|');
        }
        return sb.toString();
    }

    // ----- 동일성 비교 -----
    private boolean same(boolean[][] a, boolean[][] b) {
        if (a.length != b.length) return false;
        int L = a.length;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }

    // ----- 매칭 및 합산 -----
    private int matchAndCount() {
        int total = 0;

        for (Map.Entry<Integer, List<boolean[][]>> e : board_map.entrySet()) {
            int area = e.getKey();
            List<boolean[][]> vacancies = e.getValue();                 // 보드 빈칸들
            List<List<boolean[][]>> candidates = table_map.getOrDefault(area, new ArrayList<>()); // 테이블 후보(각각 회전묶음)

            Iterator<boolean[][]> itVac = vacancies.iterator();
            while (itVac.hasNext()) {
                boolean[][] target = itVac.next();

                int foundIdx = -1;
                for (int i = 0; i < candidates.size() && foundIdx == -1; i++) {
                    List<boolean[][]> variants = candidates.get(i);
                    for (boolean[][] rot : variants) {
                        if (same(target, rot)) {
                            foundIdx = i;
                            break;
                        }
                    }
                }

                if (foundIdx != -1) {
                    candidates.remove(foundIdx); // 조각 하나 소비
                    total += area;
                    itVac.remove(); // 빈칸 채움
                }
            }

            if (candidates.isEmpty()) table_map.remove(area);
            else table_map.put(area, candidates);
        }

        return total;
    }
}