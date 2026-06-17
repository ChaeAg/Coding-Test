class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] forward = new int[n];
        int[] backward = new int[n];
        forward[0] = nums[0];
        backward[n-1] = nums[n-1];

        for(int i=1; i<n; i++) {
            forward[i] = forward[i-1] * nums[i];
            backward[n-i-1] = backward[n-i] * nums[n-i-1];
        }

        int[] answer = new int[n];
        answer[0] = backward[1];
        answer[n-1] = forward[n-2];
        for(int i=1; i<n-1; i++) {
            answer[i] = forward[i-1] * backward[i+1];
        }

        return answer;
    }
}