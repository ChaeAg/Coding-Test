class Solution {
    public void sortColors(int[] nums) {
        int zeroIdx = 0, twoIdx = nums.length-1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 2) {
                while(i < twoIdx) {
                    if(nums[twoIdx] == 2) {
                        twoIdx--;
                        continue;
                    }
                    nums[i] = nums[twoIdx];
                    nums[twoIdx--] = 2;
                    break;
                }
            }

            if(nums[i] == 0) {
                nums[i] = nums[zeroIdx];
                nums[zeroIdx++] = 0;
            }
        }
    }
}