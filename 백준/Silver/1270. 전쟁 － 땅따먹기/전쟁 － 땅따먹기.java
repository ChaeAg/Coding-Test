import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			Map<String, Integer> map = new HashMap<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			boolean cond = false;
			while(st.hasMoreTokens()) {
				String number = st.nextToken();
				map.put(number, map.getOrDefault(number, 0) + 1);
				if(map.get(number) > count / 2) {
					sb.append(number).append("\n");
					cond = true;
					break;
				}
			}
			if(!cond) {
				sb.append("SYJKGW").append("\n");
			}
		}
		System.out.print(sb);
	}
}