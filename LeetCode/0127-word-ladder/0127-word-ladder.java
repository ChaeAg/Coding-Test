import java.util.*;
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        Queue<int[]> que = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            String str = wordList.get(i);
            if(possable(beginWord, str)) {
                if(str.equals(endWord)) return 2;
                
                que.add(new int[]{i, 2});
                visited[i] = true;
            }
        }

        while(!que.isEmpty()) {
            int[] arr = que.poll();
            String s = wordList.get(arr[0]);

            for(int i=0; i<n; i++) {
                if(visited[i]) continue;

                String str = wordList.get(i);
                if(possable(s, str)) {
                    if(str.equals(endWord)) {
                        return arr[1]+1;
                    }
                    que.add(new int[]{i, arr[1]+1});
                    visited[i] = true;
                }
            }
        }

        return 0;
    }

    boolean possable(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int cnt = 0;

        for(int i=0; i<arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                cnt++;
                if(cnt >= 2) return false;
            }
        }

        return true;
    }
}