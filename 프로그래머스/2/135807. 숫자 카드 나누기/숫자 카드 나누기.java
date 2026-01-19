class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcdA = gcd(arrayA);
        int gcdB = gcd(arrayB);
        int copy_gcdA = gcdA;
        int copy_gcdB = gcdB;
        
        for(int i=0; i<arrayA.length; i++) {
            if(arrayB[i] % copy_gcdA == 0) {
                gcdA = 0;
            }
            
            if(arrayA[i] % copy_gcdB == 0) {
                gcdB = 0;
            }
        }
        
        return Math.max(gcdA, gcdB);
    }
    
    public int gcd(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}