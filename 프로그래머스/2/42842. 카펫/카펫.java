class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 2w + 2h - 4 = brown
        int w_and_h = (brown + 4) / 2;
        
        // 가로 길이 찾기
        for(int w = (w_and_h / 2); w <= w_and_h-3; w++) {
            int h = w_and_h - w;
            if(yellow == (w-2)*(h-2)){ // 가로, 세로 길이로 yellow 수 구하는 법
                answer[0] = w;
                answer[1] = h;
            }
        }
        
        return answer;
    }
}