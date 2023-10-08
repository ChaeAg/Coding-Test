import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] workname = {"Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex"};

		for(String s: workname) {
			map.put(s, 0);
		}

		String works = "", work;
		double total = 0.0;
	
		while ((works = br.readLine()) != null) {
			st = new StringTokenizer(works);
			while(st.hasMoreTokens()) {
				work = st.nextToken();
				if(map.containsKey(work)) {
					map.put(work, map.get(work)+1);
				}
				total++;
			}
		}

		for(String s : workname) {
			String ratio = String.format("%.2f", map.get(s) / total);
			sb.append(s).append(" ").append(map.get(s)).append(" ").append(ratio).append("\n");
		}
	
		sb.append("Total ").append((int)total).append(" 1.00");
		System.out.println(sb);
	}
}