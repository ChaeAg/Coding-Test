import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for(int i=0; i<M; i++) {
            String[] arr = br.readLine().split(" ");
            switch (arr[0]) {
                case "add":
                    if(!list.contains(arr[1])) list.add(arr[1]);
                    break;
                case "remove":
                    if(list.contains(arr[1])) list.remove(arr[1]);
                    break;
                case "check":
                    sb.append(list.contains(arr[1]) ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    if(list.contains(arr[1])) list.remove(arr[1]);
                    else list.add(arr[1]);
                    break;
                case "all":
                    list.clear();
                    list = IntStream.rangeClosed(1, 20)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.toList());
                    break;
                case "empty":
                    list.clear();
                    break;
            }
        }
        System.out.print(sb);
	}
}