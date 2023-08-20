class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int i=0; i<queries.length; i++){
            for(int k=queries[i][0]; k<=queries[i][1]; k++)
                arr[k]++;
        }
        return arr;
    }
}