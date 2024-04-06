class Solution {
    String target;
    String[] words;
    int answer = 0;
    int word_len;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.words = words;
        word_len = words[0].length();
        visited = new boolean[words.length];

        dfs(0, begin);
        
        return answer;
    }
    
    public void dfs(int count, String begin) {
        if(begin.equals(target)) {
            if(answer == 0) answer = count;
            else answer = answer > count ? count : answer;
            return;
        }

        for(int i=0; i<words.length; i++) {
            if(words[i].equals(begin) || visited[i]) continue;

            char[] c_begin = begin.toCharArray();
            char[] c_word = words[i].toCharArray();
            int different_count = 0;

            for(int j=0; j<word_len; j++) {
                if(c_begin[j] != c_word[j]) different_count++;

                if(different_count > 1) break;
            }

            if(different_count == 1) {
                visited[i] = true;
                dfs(count + 1, words[i]);
                visited[i] = false;
            }
        }
    }
}