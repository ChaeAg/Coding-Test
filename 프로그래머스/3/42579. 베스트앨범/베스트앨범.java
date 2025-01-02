import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> genre_play_count = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genre_play_count.put(genres[i], genre_play_count.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> keySet = new ArrayList<>(genre_play_count.keySet());
        keySet.sort((o1, o2) -> genre_play_count.get(o2).compareTo(genre_play_count.get(o1))); // 장르별 재생 횟수 기준 내림차순 정렬

        int[][] temp = new int[keySet.size()][2];
        for (int i = 0; i < temp.length; i++) {
            Arrays.fill(temp[i], -1);
        }
        
        for (int i = 0; i < plays.length; i++) {
            int idx = keySet.indexOf(genres[i]); // 몇번째로 많이 재생된 장르인지 찾기
            if (temp[idx][0] == -1 || plays[temp[idx][0]] < plays[i]) {
                temp[idx][1] = temp[idx][0];
                temp[idx][0] = i;
            } else if (temp[idx][1] == -1 || plays[temp[idx][1]] < plays[i]) {
                temp[idx][1] = i;
            }
        }
    
        for(int[] arr : temp) {
            for(int a : arr) {
                answer.add(a);
            }
        }
        
        return answer.stream().mapToInt(i->i).filter(i -> i != -1).toArray();
    }
}