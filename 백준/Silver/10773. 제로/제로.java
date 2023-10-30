import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> numbers = new ArrayList<>();

		for(int i=0; i<N; i++) {
			int number = Integer.parseInt(br.readLine());
			if(number == 0) {
				numbers.remove(numbers.size()-1);
				continue;
			}
			numbers.add(number);
		}

		System.out.print(numbers.stream().mapToInt(Integer::intValue).sum());
	}
}