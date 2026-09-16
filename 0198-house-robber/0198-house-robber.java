class Solution {
    public int rob(int[] nums) {
        int len = nums.length + 2;
        int[] dp = new int[len];

        for(int i=2; i<len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-2]);
        }

        return dp[len-1];
    }
}