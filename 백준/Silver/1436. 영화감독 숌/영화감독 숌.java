import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int jongmal = 666;
		int count = 1;

		while(count < N) {
			jongmal++;
			if(String.valueOf(jongmal).contains("666")){
				count++;
			}
		}

		System.out.println(jongmal);
	}
}