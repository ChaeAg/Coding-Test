import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int count = 0;

                while(A < B) {
                        if(B % 10 == 1) {
                                B /= 10;
                                count++;
                        }
                        else if(B % 2 == 0) {
                                B /= 2;
                                count++;
                        }
                        else break;
                }
                if(A == B) System.out.print(count+1);
                else System.out.print("-1");
        }
}