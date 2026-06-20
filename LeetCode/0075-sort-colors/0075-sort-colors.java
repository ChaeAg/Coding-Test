class Solution {
    public void sortColors(int[] nums) {
        int zeroIdx = 0, twoIdx = nums.length-1;
        for(int i=0; i<nums.length; i++) {
            while(i < twoIdx && nums[i] == 2) {
                nums[i] = nums[twoIdx];
                nums[twoIdx--] = 2;
            }

            if(nums[i] == 0) {
                nums[i] = nums[zeroIdx];
                nums[zeroIdx++] = 0;
            }
        }
    }
}