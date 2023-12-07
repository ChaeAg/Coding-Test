import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int N = Integer.parseInt(br.readLine());
                int winnerNumber = 0;
                int maxNum = 0;
                for(int i=0; i<N; i++) {
                        int[] arr = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                        int max = 0;
                        for(int k=0; k<arr.length-2; k++) {
                                for(int k2=k+1; k2<arr.length-1; k2++) {
                                        for(int k3=k2+1; k3<arr.length; k3++) {
                                                if(max < (arr[k]+arr[k2]+arr[k3])%10) {
                                                        max = (arr[k]+arr[k2]+arr[k3]) % 10;
                                                }
                                        }
                                }
                        }
                        if(maxNum <= max){
                                maxNum = max;
                                winnerNumber = i+1;
                        }
                }
                System.out.print(winnerNumber);
        }
}