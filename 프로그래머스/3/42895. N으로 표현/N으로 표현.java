// import java.util.*;
// class Solution {
//     public int solution(int N, int number) {
//         List<Integer> n_list = new ArrayList<>();
        
//         String s = String.valueOf(N);
//         String str = "";
        
//         for(int i=0; i<String.valueOf(number).length(); i++) {
//             str += s;
//             n_list.add(Integer.parseInt(str));
//         }
        
//         Queue<Integer> q = new LinkedList<>();
//         int[] dp = new int[number * N + 1];
        
//         for(int i=0; i<n_list.size(); i++) {
//             dp[n_list.get(i)] = i + 1; // NN 이면 2, NNN이면 3
//             q.add(n_list.get(i));
//         }
    
//         while(!q.isEmpty()) {
//             int num = q.poll();
            
//             for(int i=0; i<n_list.size(); i++) {
//                 // 더하기
//                 int tmp = num + n_list.get(i);
//                 if(tmp > 0 && tmp < dp.length) {
//                     if(dp[tmp] == 0 || dp[tmp] > dp[num] + i + 1) {
//                         if(dp[num] + i + 1 <= 8) {
//                             dp[tmp] = dp[num] + i + 1;
//                             q.add(tmp);
//                         }
//                     }   
//                 }
                
//                 // 빼기 1
//                 tmp = num - n_list.get(i);
//                 if(tmp > 0) {
//                     if(dp[tmp] == 0 || dp[tmp] > dp[num] + i + 1) {
//                         if(dp[num] + i + 1 <= 8) {
//                             dp[tmp] = dp[num] + i + 1;
//                             q.add(tmp);
//                         }
//                     }
//                 }
//                 // 빼기 2
//                 tmp = n_list.get(i) - num;
//                 if(tmp > 0) {
//                     if(dp[tmp] == 0 || dp[tmp] > dp[num] + i + 1) {
//                         if(dp[num] + i + 1 <= 8) {
//                             dp[tmp] = dp[num] + i + 1;
//                             q.add(tmp);
//                         }
//                     }
//                 }
                
//                 // 곱하기
//                 tmp = num * n_list.get(i);
//                 if(tmp > 0 && tmp < dp.length) {
//                     if(dp[tmp] == 0 || dp[tmp] > dp[num] + i + 1) {
//                         if(dp[num] + i + 1 <= 8) {
//                             dp[tmp] = dp[num] + i + 1;
//                             q.add(tmp);
//                         }
//                     }
//                 }
                
//                 // 나누기 1
//                 tmp = num / n_list.get(i);
//                 if(tmp > 0) {
//                     if(dp[tmp] == 0 || dp[tmp] > dp[num] + i + 1) {
//                         if(dp[num] + i + 1 <= 8) {
//                             dp[tmp] = dp[num] + i + 1;
//                             q.add(tmp);
//                         }
//                     }
//                 }
//                 // 나누기 2
//                 tmp =  n_list.get(i) / num;
//                 if(tmp > 0) {
//                     if(dp[tmp] == 0 || dp[tmp] > dp[num] + i + 1) {
//                         if(dp[num] + i + 1 <= 8) {
//                             dp[tmp] = dp[num] + i + 1;
//                             q.add(tmp);
//                         }
//                     }
//                 }
//             }
//         }
        
//         return dp[number] == 0 ? -1 : dp[number];
//     }
// }

import java.util.*;
class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> list = new ArrayList();
        
        String s = String.valueOf(N);
        String str = "";
        for(int i=0; i<=8; i++) {
            Set<Integer> set = new HashSet<>();
            set.add(str.equals("") ? 0 : Integer.parseInt(str));
            list.add(set);
            str += s;
        }
        
        for(int i=1; i<=8; i++) {
            Set<Integer> set = list.get(i);
            for(int j=1; j<i; j++) {
                for(int a : list.get(j)) {
                    for(int b : list.get(i-j)) {
                        set.add(a + b);
                        set.add(a - b);
                        set.add(b - a);
                        set.add(b * a);
                        
                        if(a != 0) set.add(b / a);
                        if(b != 0) set.add(a / b);
                    }
                }        
            }
            
            if(set.contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}

