class Solution
{
    public int solution(String s)
    {
        String[] arr = s.split("");
        int len = arr.length;
        int maxResult = 0;
        
        for(int i=1; i<len-1; i++) {
            int gauge = 1;
            for(int j=1; j<=i && j<len-i; j++) {
                if(!arr[i-j].equals(arr[i+j])) {
                    break;
                }
                gauge += 2;
            }
            
            maxResult = Math.max(maxResult, gauge);
        }

        return maxResult;
    }
}