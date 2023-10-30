import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] fileNames = new String[N];
		int[] differentIndex = new int[50];

		for(int i=0; i<N; i++) {
			fileNames[i] = br.readLine();
		}

		StringBuilder stringBuilder = new StringBuilder(fileNames[0]);

		for(int i=0; i<fileNames[0].length(); i++) {
			for(int k=0; k<N-1; k++) {
				if(fileNames[k].charAt(i) != fileNames[k+1].charAt(i)) {
					differentIndex[i]++;
					break;
				}
			}
		}

		for(int i=0; i<fileNames[0].length(); i++) {
			if(differentIndex[i] > 0) {
				stringBuilder.setCharAt(i, '?');;
			}
		}
		
		System.out.print(stringBuilder);
	}
}