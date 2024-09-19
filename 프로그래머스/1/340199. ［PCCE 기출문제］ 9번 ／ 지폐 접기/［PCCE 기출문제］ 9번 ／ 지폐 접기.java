class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        if(wallet[0] < wallet[1]) {
            int temp = wallet[0];
            wallet[0] = wallet[1];
            wallet[1] = temp;
        }

        if(bill[0] < bill[1]) {
            int temp = bill[0];
            bill[0] = bill[1];
            bill[1] = temp;
        }

        while(wallet[0] < bill[0] || wallet[1] < bill[1]) {
            if(bill[0] > bill[1]) {
                bill[0] /= 2;
            }
            else {
                bill[1] /= 2;
            }
            
            answer++;
            
            if(bill[0] < bill[1]) {
                int temp = bill[0];
                bill[0] = bill[1];
                bill[1] = temp;
            }
        }
        
        return answer;
    }
}