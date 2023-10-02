import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> m = new HashMap<String,Integer>();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String k = st.nextToken();
			int v = Integer.parseInt(st.nextToken());

			m.put(k, m.containsKey(k) ? m.get(k) + v : v);
		}

		if(m.containsValue(5)) {
			System.out.println("YES");
		} 
		else {
			System.out.println("NO");
		}
	}
}