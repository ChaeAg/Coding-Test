class Solution {
    // 누적합인데 원형큐?
    public int solution(int[] queue1, int[] queue2) {
        int len = queue1.length;
        
        long[] first_que1 = new long[len * 2];
        long[] first_que2 = new long[len * 2];
        
        first_que1[0] = queue1[0];
        first_que2[0] = queue2[0];
        
        for(int i=1; i<len; i++) {
            first_que1[i] = queue1[i] + first_que1[i-1];
            first_que2[i] = queue2[i] + first_que2[i-1];
        }
        
        if(first_que1[len-1] == first_que2[len-1]) return 0;
        
        for(int i=0; i<len; i++) {
            first_que1[len+i] = queue2[i] + first_que1[len+i-1];
            first_que2[len+i] = queue1[i] + first_que2[len+i-1];
        }
        
        long target = first_que1[len*2-1];
        
        if(target % 2 != 0) { // 두 큐의 전체 합이 홀수라면 두 큐의 각 합을 같게 만들 수가 없다.
            return -1;
        }
        
        int min_cnt = find_min_cnt(target/2, len, first_que1, first_que2);
        
        return min_cnt == Integer.MAX_VALUE ? -1 : min_cnt;
    }
    
    int find_min_cnt(long target, int len, long[] first_que1, long[] first_que2) {
        int first_left = 0, first_right = 0;
        int second_left = 0, second_right = 0;
        int min_cnt = Integer.MAX_VALUE;
        
        while(true) {
            if(first_left <= first_right && first_left < len*2 && first_right < len*2) {
                long sum = first_left == 0 
                    ? first_que1[first_right] 
                    : first_que1[first_right] - first_que1[first_left - 1];
                
                if(sum < target) {
                    first_right++;
                }
                else if(sum > target) {
                    first_left++;
                }
                else { // 구간 찾음!
                    if(first_right >= len) {
                        min_cnt = Math.min(min_cnt, first_left + first_right - (len - 1));
                    }
                    first_left++;
                }    
            }
            
            if(second_left <= second_right && second_left < len*2 && second_right < len*2) {
                long sum = second_left == 0 
                    ? first_que2[second_right] 
                    : first_que2[second_right] - first_que2[second_left - 1];
                
                if(sum < target) {
                    second_right++;
                }
                else if(sum > target) {
                    second_left++;
                }
                else { // 구간 찾음!
                    if(second_right >= len) {
                        min_cnt = Math.min(min_cnt, second_left + second_right - (len - 1));
                    }
                    second_left++;
                }    
            }
            
            if(!(first_left <= first_right && first_left < len*2 && first_right < len*2)
              && !(second_left <= second_right && second_left < len*2 && second_right < len*2)) { // 두 배열 모두 탐색 끝.
                break;
            }
        }
        
        return min_cnt;
    }
}