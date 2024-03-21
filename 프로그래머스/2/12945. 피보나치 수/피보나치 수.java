class Solution {
    static int[] nums;
    public int solution(int n) {
        nums = new int[n+1];
        nums[1] = 1;
        return fibo(n);
    }
    
    public int fibo(int n) {
        if(n == 0) return 0;
        if(nums[n] == 0) {
            nums[n] = (fibo(n-1) + fibo(n-2)) % 1234567;
        }
        return nums[n];
    }
}