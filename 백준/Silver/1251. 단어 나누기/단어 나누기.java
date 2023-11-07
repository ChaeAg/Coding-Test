import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> resultList = new ArrayList<>();
		String input = br.readLine();
		for(int i=1; i<input.length()-1; i++) {
			for(int k=i+1; k<input.length(); k++) {
				StringBuffer sb1 = new StringBuffer(input.substring(0, i));
				StringBuffer sb2 = new StringBuffer(input.substring(i, k));
				StringBuffer sb3 = new StringBuffer(input.substring(k));
				resultList.add(sb1.reverse().toString() + sb2.reverse() + sb3.reverse());
			}
		}
		Collections.sort(resultList);
        System.out.println(resultList.get(0));
	}
}