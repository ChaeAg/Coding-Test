import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
	
		int[] nums = new int[N];
		int idx = 0;

		for(String num : br.readLine().split(" ")){
			nums[idx++] = Integer.parseInt(num);
		}

		Arrays.sort(nums);

		int[] sums = new int[N+1];
		int sum = 0;

		for(int i=1; i<=N; i++) {
			sums[i] = sums[i-1] + nums[i-1];
			sum += sums[i];
		}

		System.out.println(sum);
	}
}