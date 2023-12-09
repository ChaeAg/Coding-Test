class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] twoarr1 = new String[n];
        String[] twoarr2 = new String[n];
        
        for(int i=0; i<n; i++) {
            twoarr1[i] = String.format("%0" + n + "d", Long.valueOf(Integer.toString(arr1[i], 2)));
            twoarr2[i] = String.format("%0" + n + "d", Long.valueOf(Integer.toString(arr2[i], 2)));
        }
        
        for(int i=0; i<n; i++) {
            String result = "";
            for(int k=0; k<n; k++) {
                if(twoarr1[i].charAt(k) == '0' && twoarr2[i].charAt(k) == '0') { // 지도 1, 2 둘 다 공백일 경우
                    result += " ";
                }
                else {
                    result += "#";
                }
            }
            answer[i] = result;
        }
        
        return answer;
    }
}