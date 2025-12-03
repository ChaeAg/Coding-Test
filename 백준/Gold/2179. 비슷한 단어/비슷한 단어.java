import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strs = new String[N];
        Map<String, Integer> count = new HashMap<>(); // {부분 문자열 -> 등장 횟수}
        Map<String, List<Integer>> index = new HashMap<>(); // {부분 문자열 -> [포함하고 잇는 단어들 인덱스, ..]}

        int maxLen = 0;
        List<String> maxCntStrList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            strs[i] = br.readLine();

            for (int k = 0; k <= strs[i].length(); k++) {
                String subStr = strs[i].substring(0, k);

                int cnt = count.getOrDefault(subStr, 0) + 1;
                count.put(subStr, cnt);

                if (cnt >= 2) {
                    if (maxLen < subStr.length()) {
                        maxCntStrList = new ArrayList<>();
                        maxCntStrList.add(subStr);
                        maxLen = subStr.length();
                    } else if ((maxLen == subStr.length())) {
                        maxCntStrList.add(subStr);
                    }
                }

                index.computeIfAbsent(subStr, j -> new ArrayList<>()).add(i);
            }
        }

        int minIdx = N;
        String resultSubStr = "";

        for (int i = 0; i < maxCntStrList.size(); i++) {
            String subStr = maxCntStrList.get(i);
            int nowIdx = index.get(subStr).stream().min(Comparator.comparingInt(k -> k)).get();
            if (minIdx > nowIdx) {
                minIdx = nowIdx;
                resultSubStr = subStr;
            }
        }

        List<Integer> result = index.get(resultSubStr);
        System.out.println(strs[result.get(0)]);
        System.out.print(strs[result.get(1)]);
    }
}