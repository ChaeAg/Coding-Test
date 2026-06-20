class Solution {
    public int[] sortColors(int[] nums) {
        int c0 = 0, c1 = 0, c2 = 0;
        for(int num : nums) {
            if(num == 0) c0++;
            else if(num == 1) c1++;
            else c2++;
        }

        for(int i=0; i<nums.length; i++) {
            if(c0-- > 0) {
                nums[i] = 0;
            } else if(c1-- > 0) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }

        return nums;
    }
}