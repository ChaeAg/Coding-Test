class Solution {
    public int beautySum(String s) {
        int result = 0;
        for(int i=0; i<s.length(); i++) {
            int[] arr = new int[26];
            for(int j=i; j<s.length(); j++) {
                arr[s.charAt(j) - 'a']++;
                result += cal(arr);
            }
        }
        return result;
    }

    int cal(int[] arr) {
        int max = 0, min = Integer.MAX_VALUE;
        for(int i=0; i<26; i++) {
            if(arr[i] != 0) {
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
            }
        }
        return max - min;
    }
}