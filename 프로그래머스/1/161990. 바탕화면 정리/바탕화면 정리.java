class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        String[][] wp = new String[wallpaper.length][wallpaper[0].length()];
        for (int i = 0; i < wallpaper.length; i++) {
            wp[i] = wallpaper[i].split("");
        }

        int[] first_start = null;
        int[] first_end = new int[2];
        for(int i=0; i<wp.length; i++) {
            for(int j=0; j<wp[0].length; j++) {
                if(wp[i][j].equals("#")) {
                    if(first_start == null) {
                        first_start = new int[]{i, j};
                    }
                    first_end[0] = i;
                    first_end[1] = j;
                }
            }
        }

        int[] second_start = null;
        int[] second_end = new int[2];
        for(int j=0; j<wp[0].length; j++) {
            for(int i=0; i<wp.length; i++) {
                if(wp[i][j].equals("#")) {
                    if(second_start == null) {
                        second_start = new int[]{i, j};
                    }
                    second_end[0] = i;
                    second_end[1] = j;
                }
            }
        }

        answer[0] = Math.min(first_start[0], second_start[0]);
        answer[1] = Math.min(first_start[1], second_start[1]);
        answer[2] = Math.max(first_end[0], second_end[0]) + 1;
        answer[3] = Math.max(first_end[1], second_end[1]) + 1;
        
        return answer;
    }
}