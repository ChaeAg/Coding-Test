import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String doc = br.readLine();
        String word = br.readLine();
        String newDoc = doc.replaceAll(word, "");
        System.out.print((doc.length() - newDoc.length()) / word.length());
    }
}