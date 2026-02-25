class Solution {
    int[] arr;
    boolean[] visited;
    boolean answer = false;
    public boolean canReach(int[] arr, int start) {
        this.arr = arr;
        visited = new boolean[arr.length];
        visited[start] = true;
        dfs(start);
        return answer;
    }

    public void dfs(int now) {
        if(arr[now] == 0) {
            answer = true;
            return;
        }

        int d = arr[now];
        if(now + d < arr.length && !visited[now + d]) {
            visited[now + d] = true;
            dfs(now+d);
        }
        if(now - d >= 0 && !visited[now - d]) {
            visited[now - d] = true;
            dfs(now-d);
        }
    }
}