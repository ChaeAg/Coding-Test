class Solution {
    public int solution(int[] a) {
        int n = a.length;
        
        if (n <= 2) return n;
        
        // 왼쪽에서의 최솟값 배열
        int[] leftMin = new int[n];
        leftMin[0] = a[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }
        
        // 오른쪽에서의 최솟값 배열
        int[] rightMin = new int[n];
        rightMin[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            // 양 끝은 무조건 가능함
            if (i == 0 || i == n - 1) {
                count++;
                continue;
            }
            
            // 왼쪽 최솟값과 오른쪽 최솟값 중 최대 1개만 현재 값보다 작아야 함
            boolean leftSmaller = leftMin[i - 1] < a[i];
            boolean rightSmaller = rightMin[i + 1] < a[i];
            
            if (!leftSmaller || !rightSmaller) {
                count++;
            }
        }
        
        return count;
    }
}