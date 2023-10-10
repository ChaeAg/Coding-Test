import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int kg = 0, count = 0, three_count = 0;

		while(kg <= N) {
			if((N - kg) % 5 == 0) {
				count += (N - kg) / 5 + three_count;
				break;
			}
			kg += 3;
			three_count++;
		}
		if(count == 0) System.out.println("-1");
		else System.out.println(count);
	}
}