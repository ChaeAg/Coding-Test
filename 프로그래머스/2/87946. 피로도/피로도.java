class Solution {
    public static int max = 0;
    public static int fatigue;
    public static int size;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        size = dungeons.length;      
        fatigue = k;
        permutation(dungeons, 0);
        return max;
    }
    
    static void permutation(int[][] arr, int depth) {
        if(depth == size) {
            int count = 0;
            int k = fatigue;
            for(int i=0; i<arr.length; i++) {
                if(arr[i][0] > k) break;
                k -= arr[i][1];
                count++;
            }
            if(max < count) max = count;
            return;
        }
 
        for(int i=depth; i<size; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1);
            swap(arr, depth, i);
        }
    }
 
    static void swap(int[][] arr, int depth, int i) {
        int[] temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}