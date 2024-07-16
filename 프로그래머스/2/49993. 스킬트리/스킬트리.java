class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String skill_tree : skill_trees) {
            int idx = 0;
            String word = skill.substring(idx, idx+1);
            boolean isFalse = false;
            for(String s : skill_tree.split("")) {
                if(!word.equals(s) && skill.contains(s)) {
                    isFalse = true;
                    break;
                }
                if(word.equals(s)) {
                    idx++;
                    if(idx >= skill.length()-1) break;
                    word = skill.substring(idx, idx+1);
                }
            }
            
            if(!isFalse) answer++;
        }
        
        return answer;
    }
}