import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        Map<Integer, Integer> numCounts = new HashMap<>();

        // N에 0~9까지 수가 각각 몇번씩 등장하는지 카운트
        numCounts.put(0, N.length() - N.replaceAll("0", "").length());
        numCounts.put(1, N.length() - N.replaceAll("1", "").length());
        numCounts.put(2, N.length() - N.replaceAll("2", "").length());
        numCounts.put(3, N.length() - N.replaceAll("3", "").length());
        numCounts.put(4, N.length() - N.replaceAll("4", "").length());
        numCounts.put(5, N.length() - N.replaceAll("5", "").length());

        // 6과 9를 하나로 생각하긔
        numCounts.put(6, N.length() - N.replaceAll("6", "").replaceAll("9","").length());

        numCounts.put(7, N.length() - N.replaceAll("7", "").length());
        numCounts.put(8, N.length() - N.replaceAll("8", "").length());

        int maxCountNum = 0;
        int sixAndNineCalculate = numCounts.get(6) % 2 == 0 ? numCounts.get(6) / 2 : numCounts.get(6) / 2 + 1;

        for(int key : numCounts.keySet()) {
            if(key == 6 && numCounts.get(maxCountNum) < sixAndNineCalculate) {
                maxCountNum = 6;
            }
            else if(maxCountNum == 6 && sixAndNineCalculate < numCounts.get(key)) {
                maxCountNum = key;
            }
            else if(maxCountNum != 6 && numCounts.get(maxCountNum) < numCounts.get(key)) {
                maxCountNum = key;
            }
        }

        if (maxCountNum == 6) {
            System.out.print(sixAndNineCalculate);
        } else {
            System.out.print(numCounts.get(maxCountNum));
        }
    }
}