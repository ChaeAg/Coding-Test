import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		HashMap<String, String> map = new HashMap<String, String>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String str;
		while((str = br.readLine()) != null) {
			String [] a = str.split(" ");
			if(a.length == 2) {
				map.put(a[0], a[1]);
			}
			else {
				sb.append(map.get(a[0])).append("\n");
			}
		}

		System.out.print(sb);
	}
}