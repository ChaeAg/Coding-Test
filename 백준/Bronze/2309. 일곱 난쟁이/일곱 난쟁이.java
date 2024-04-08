import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[9];
        int sum = 0;

        for(int i=0; i<9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
            sum += heights[i];
        }
        
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(i==j) continue;
                if(heights[i] + heights[j] == sum - 100) {
                    heights[i] = heights[j] = 101;
                    Arrays.sort(heights);
                    for(int k=0; k<7; k++) {
                        System.out.println(heights[k]);
                    }
                    return;
                }
            }
        }
    }
}