class Solution {
    public int lengthLongestPath(String input) {
        int max = 0;
        int[] depths = new int[10000];
        String[] strs = input.split("\n");
        // [dir, \tsubdir1, \t\tfile1.ext, ....]

        for(int i=0; i<strs.length; i++) {
            int depth = 0;
            int len = 0;
            for(int k=0; k<strs[i].length(); k++) {
                if(strs[i].substring(k, k+1).equals("\t")) {
                    depth++;
                } else {
                    len = strs[i].length() - k;
                    break;
                }
            }

            depths[depth] = len;

            if(strs[i].contains(".")) { // strs[i] is file.
                int pathLen = depth; // 경로 사이의 '/' 개수 = depth
                for(int k=0; k<=depth; k++) {
                    pathLen += depths[k];
                }
                max = Math.max(max, pathLen);
            }
        }

        return max;
    }
}