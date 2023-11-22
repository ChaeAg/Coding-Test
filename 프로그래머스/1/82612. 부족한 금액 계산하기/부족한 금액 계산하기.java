class Solution {
    public long solution(int price, int money, int count) {
        long copyPrice = Long.valueOf(price);
        long totalPrice = 0L;
        for(int i=1; i<=count; i++) {
            totalPrice += copyPrice;
            copyPrice += Long.valueOf(price);
        }
        if(totalPrice > money) return totalPrice - money;
        else return 0;
    }
}