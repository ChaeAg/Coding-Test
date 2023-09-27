import java.util.*;
import java.io.*;

public class Main {
	static int N, K, M;
	static StringTokenizer st;
	static ArrayList<Integer> num;
	static StringBuilder sb;
	static int count;
	static int idx;
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		num = new ArrayList<>();
		sb = new StringBuilder();
		

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		idx = -1;
		count = 0;
		for(int i=1; i<=N; i++) {
			num.add(i);
		}

		while(!num.isEmpty()) {
			for(int i=0; i<K; i++) {
				idx++;
				if(idx >= num.size()) {
					idx = 0;
				}
			}
			sb.append(num.get(idx)).append("\n");
			num.remove(idx);
			count++;

			if(count == M) {
				Backwards();
				count = 0;
			}
			idx--;
		}

		System.out.println(sb);
	}
	private static void Backwards(){
		count = 0;
		while(!num.isEmpty() && count < M) {
			for(int i=0; i<K; i++) {
				idx--;
				if(idx < 0) {
					idx = num.size()-1;
				}
			}
			sb.append(num.get(idx)).append("\n");
			num.remove(idx);
			count++;
		}
	}
}