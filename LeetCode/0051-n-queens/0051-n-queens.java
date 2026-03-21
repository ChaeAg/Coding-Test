class Solution {
    int[] graph;
    int n;
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if(n == 1) {
            result.add(List.of("Q"));
        } else {
            graph = new int[n];
            Arrays.fill(graph, -1);
            this.n = n;
            back(0);
        }
        
        return result;
    }

    void back(int row) {
        if (row == 0) {
            for (int i = 0; i < n; i++) {
                graph[0] = i;
                back(row + 1);
            }
        } else {
            List<Integer> possableList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                possableList.add(i);
            }

            for (int r = row - 1; r >= 0; r--) {
                int col = graph[r];
                possableList.remove((Integer) col); // 세로선

                possableList.remove((Integer) (col + (row - r))); // 오른쪽 대각선

                possableList.remove((Integer) (col - (row - r))); // 왼쪽 대각선
            }

            for (int i : possableList) {
                graph[row] = i;
                if (row == n - 1) {
                    addResult();
                    continue;
                }
                back(row + 1);
            }
        }
    }

    void addResult() {
        List<String> temp = new ArrayList<>();
        StringBuilder sb;
        for (int g : graph) {
            sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i == g) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            temp.add(sb.toString());
        }
        result.add(temp);
    }
}