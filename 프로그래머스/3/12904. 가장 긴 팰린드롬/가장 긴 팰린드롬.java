class Solution
{
    public int solution(String s)
    {
        String[] arr = s.split("");
        int len = arr.length;
        int maxResult = 1;
        
        if(arr.length == 2) {
            return arr[0].equals(arr[1]) ? 2 : 1;
        }
        
        for(int i=1; i<len-1; i++) {
            int gauge, left, right;
            
            // 짝수 길이
            if(arr[i-1].equals(arr[i]) || arr[i+1].equals(arr[i])) {
                gauge = 2;
                
                if(arr[i-1].equals(arr[i])) {
                    left = i-1; right = i;    
                } else {
                    left = i; right = i+1;
                }
                
                while(--left >= 0 && ++right < len) {
                    if(!arr[left].equals(arr[right])) {
                        break;
                    }
                    gauge += 2;
                }
                
                maxResult = Math.max(maxResult, gauge);
            }
            
            // 홀수 길이
            gauge = 1;
            left = i; right = i;
            while(--left >= 0 && ++right < len) {
                if(!arr[left].equals(arr[right])) {
                    break;
                }
                gauge += 2;
            }
            
            maxResult = Math.max(maxResult, gauge);
        }

        return maxResult;
    }
}