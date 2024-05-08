import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double sum = 0;
        double sum2 = 0;
        for(int i=0; i<20; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            double hakjum = Float.parseFloat(st.nextToken());
            String grade = st.nextToken();
            if(grade.equals("P")) continue;

            sum += hakjum;
            sum2 += cal(grade, hakjum);
        }

        System.out.printf("%.6f", sum2 / sum);
    }

    public static double cal(String grade, double hakjum) {
        switch(grade) {
            case "A+":
                return hakjum * 4.5;
            case "A0":
                return hakjum * 4.0;
            case "B+":
                return hakjum * 3.5;
            case "B0":
                return hakjum * 3.0;
            case "C+":
                return hakjum * 2.5;
            case "C0":
                return hakjum * 2.0;
            case "D+":
                return hakjum * 1.5;
            case "D0":
                return hakjum;
        }

        return 0;
    }
}