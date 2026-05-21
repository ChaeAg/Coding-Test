class Solution {
    public int longestOnes(int[] nums, int k) {
        int total_len = 0;
        int max = 0;
        int used = 0;
        Queue<Integer> que = new LinkedList<>();
        for(int num : nums) {
            if(k == 0) {
                if(num == 1) total_len++;
                else total_len = 0;
                max = Math.max(max, total_len);
                continue;
            }
            if(num == 0) {
                if(used == k) {
                    while(!que.isEmpty()) {
                        int i = que.poll();
                        total_len--;
                        if(i == 1) {
                            continue;
                        } else {
                            used--;
                            break;
                        }
                    }
                }
                used++;
            }
            que.add(num);
            total_len++;
            max = Math.max(max, total_len);
        }

        return max;
    }
}