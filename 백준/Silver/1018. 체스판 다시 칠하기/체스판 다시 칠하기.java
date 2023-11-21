import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = new StringTokenizer(br.readLine());
                int column = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());

                String[][] arr = new String[column][row];

                for(int i=0; i<column; i++) {
                    String str = br.readLine();
                    for(int j=0; j<row; j++) {
                        arr[i][j] = str.substring(j, j+1);
                    }
                }

                int[] changeCount = new int[(column-7) * (row-7) * 2];
                int idx=0;

                for(int s=0; s<=column-8; s++) {
                    for(int i=0; i<=row-8; i++) {
                        String color = "W";
                        for(int j=0; j<2; j++) {
                            for(int p=i; p<i+8; p++) {
                                for(int k=s; k<s+8; k++) {
                                    if(!arr[k][p].equals(color)) changeCount[idx]++;
                                    if(k == s+7) continue;
                                    if(color.equals("W")) color = "B";
                                    else color = "W";
                                }
                            }
                            color = "B";
                            idx++;
                        }  
                    }
                }
                System.out.print(Arrays.stream(changeCount).min().getAsInt());
        }
}