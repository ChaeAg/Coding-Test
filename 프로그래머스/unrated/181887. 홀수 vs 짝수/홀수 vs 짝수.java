class Solution {
    public int solution(int[] num_list) {
        int oddsum = 0, evensum = 0;
        
        for(int i=1; i<=num_list.length; i+=2)
            oddsum += num_list[i-1];
        for(int i=2; i<=num_list.length; i+=2)
            evensum += num_list[i-1];
        
        if(oddsum > evensum) return oddsum;
        else return evensum;
    }
}