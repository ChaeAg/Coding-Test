import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited = new boolean[7];
    static String[] nums;
    public int solution(String numbers) {
        int answer = 0;
        nums = numbers.split("");
        dfs("", 0); // 만들 수 있는 수 다 set에 넣음

        for (int num : set) {
            if (isSosu(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void dfs(String s, int idx) {
        if (idx > nums.length) {
            return;
        }

        for (int i=0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(s + nums[i]));
                dfs(s + nums[i], idx + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean isSosu(int n) { // 소수 판별
        if (n < 2) {
            return false;
        }

        for (int i=2; i*i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}