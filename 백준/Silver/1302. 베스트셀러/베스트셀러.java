import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> books = new HashMap<>();
        
        // map에 책 제목을 key, 팔린 수를 value로 저장
        for(int i=0; i<N; i++) {
            String book = br.readLine();
            books.put(book, books.getOrDefault(book, 0) + 1);
        }

        // 초기값은 맨 처음 map 처음 값으로 할당
        String maxBook = books.keySet().stream()
                .findFirst()
                .get();
        
        for(String key : books.keySet()) {
            if(books.get(key) > books.get(maxBook)) maxBook = key;
            else if(books.get(key) == books.get(maxBook)) { // 팔린 수가 같으면 사전 순으로 앞선 책이 max
                if(key.compareTo(maxBook) < 0) maxBook = key; // 음수면 매개변수가 더 큰거
            }
        }

        System.out.print(maxBook);
    }
}