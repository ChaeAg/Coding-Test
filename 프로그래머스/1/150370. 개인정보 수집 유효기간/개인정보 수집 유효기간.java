import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] parts = term.split(" ");
            termMap.put(parts[0], Integer.parseInt(parts[1]));
        }

        String[] todayParts = today.split("\\.");
        int todayYear = Integer.parseInt(todayParts[0]);
        int todayMonth = Integer.parseInt(todayParts[1]);
        int todayDay = Integer.parseInt(todayParts[2]);

        List<Integer> expiredList = new ArrayList<>();

        for (int index = 0; index < privacies.length; index++) {
            String[] privacyParts = privacies[index].split(" ");
            String[] dateParts = privacyParts[0].split("\\.");

            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);
            String termType = privacyParts[1];

            int expireMonth = month + termMap.get(termType);
            int expireYear = year + (expireMonth - 1) / 12;
            int adjustedMonth = expireMonth % 12 == 0 ? 12 : expireMonth % 12;

            if (expireYear < todayYear ||
                (expireYear == todayYear && adjustedMonth < todayMonth) ||
                (expireYear == todayYear && adjustedMonth == todayMonth && day <= todayDay)) {
                expiredList.add(index + 1);
            }
        }

        return expiredList.stream().mapToInt(i -> i).toArray();
    }
}