class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, 1);
        int c = 1;

        for(int i=0; i<n; i++) {
            answer[i] = c;
            c *= nums[i];
        }

        c = 1;
        for(int i=n-1; i>=0; i--) {
            answer[i] *= c;
            c *= nums[i];
        }

        return answer;
    }
}