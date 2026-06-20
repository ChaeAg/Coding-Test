class Solution {
    public void sortColors(int[] nums) {
        for(int i=1; i<nums.length; i++) {
            int ic = i;
            for(int j=i-1; j>=0; j--) {
                if(nums[ic] < nums[j]) {
                    int tmp = nums[ic];
                    nums[ic] = nums[j];
                    nums[j] = tmp;
                    ic = j;
                }
            }
        }
    }
}