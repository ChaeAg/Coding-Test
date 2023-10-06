import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		HashMap<String, Integer> map = new HashMap<>();
        String s;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            s = br.readLine();
            if(s.length() < M) {
                continue;
            }
            if(map.containsKey(s)) {
            	map.put(s, map.get(s)+1);
        	}
        	else {
            	map.put(s, 1);
        	}
        }
		List<String> keySet = new ArrayList<>(map.keySet());

		// 조건 순서대로 정렬
        Collections.sort(keySet, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 자주 등장하는 단어 순서대로 정렬
                if (Integer.compare(map.get(o1), map.get(o2)) != 0) {
                    return Integer.compare(map.get(o2), map.get(o1));
                }
                // 등장 횟수가 같으면 길이가 긴 단어가 먼저 오도록 정렬
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                }
                // 등장 횟수와 길이가 같으면 사전 순으로 정렬
                return o1.compareTo(o2);
            }
        });

		for (String str : keySet) {
            sb.append(str + "\n");
        }
		
		System.out.println(sb);
	}
}