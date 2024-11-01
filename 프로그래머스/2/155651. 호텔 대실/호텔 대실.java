import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int room_count = 0;
        int len = book_time.length;
        int[][] times = new int[len][2];
        PriorityQueue<Integer> ing = new PriorityQueue<>();

        for(int i=0; i<len; i++) {
            int[] start_time = Arrays.stream(book_time[i][0].split(":")).mapToInt(Integer::parseInt).toArray();
            int[] end_time = Arrays.stream(book_time[i][1].split(":")).mapToInt(Integer::parseInt).toArray();

            times[i][0] = start_time[0] * 60 + start_time[1];
            times[i][1] = end_time[0] * 60 + end_time[1];
        }

        Arrays.sort(times, Comparator.comparingInt(o -> o[0]));

        for(int i=0; i<len; i++) {
            if(ing.isEmpty()) {
                room_count++;
                ing.add(times[i][1]); // 종료 시간이 제일 빠른 게 우선순위 굿
            }
            else {
                if(ing.peek() + 10 > times[i][0]) {
                    room_count++;
                }
                else {
                    ing.poll();
                }
                ing.add(times[i][1]);
            }
        }
        
        return room_count;
    }
}