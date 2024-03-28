    import java.util.*;
    class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = new int[2];
            Stack<String> word_memory = new Stack<>();
            Map<Integer, Integer> players = new HashMap<>();

            for(int i=0; i<=n; i++) {
                players.put(i, 1);
            }

            for(int i=0; i<words.length; i++) {
                int player = i % n;
                // 이미 있는 단어를 말할 경우
                // 직전 단어의 마지막 문자로 시작하는 단어를 말하지 않았을 경우
                if(i != 0) {
                    String last_word = word_memory.peek();
                    if(word_memory.contains(words[i]) ||
                       last_word.charAt(last_word.length()-1) != words[i].charAt(0)) {
                        answer[0] = player + 1;
                        answer[1] = players.get(player);
                        break;
                    }
                }

                word_memory.push(words[i]);
                players.replace(player, players.get(player) + 1);
            }

            return answer;
        }
    }