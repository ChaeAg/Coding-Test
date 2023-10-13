import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int idx = 0;
		int rule = 1;
		int len = 0;
		int num1 = 0, num2 = 0;

		while(rule <= str.length() / 2) {
			for(String s:str.substring(idx, idx+rule).split("")){
				num1 += Integer.parseInt(s);
			}
			for(String s:str.substring(idx+rule, idx+rule+rule).split("")){
				num2 += Integer.parseInt(s);
			}
			idx++;
			if(num1 == num2) len = rule;
			if(idx > str.length()-rule-rule) {
				idx = 0;
				rule++;
			}
			num1=0;
			num2=0;
		}

		System.out.println(2*len);
	}
}