import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ranking = -1;
        String[] arr = br.readLine().split(" ");
        if(Integer.parseInt(arr[0]) == 0) {
                ranking = 1;
        }
        else {
                List<Integer> list = new ArrayList<>();
                for(String num: br.readLine().split(" ")) {
                        list.add(Integer.parseInt(num));
                }
                long count = list.stream().filter(num -> num == Integer.parseInt(arr[1])).count();

                int jumsu = Integer.parseInt(arr[1]);
                list.add(jumsu);
                list.sort(Comparator.reverseOrder());    

                List<Integer> newList;
                if(list.size() > Integer.parseInt(arr[2])) newList = list.subList(0, Integer.parseInt(arr[2]));
                else newList = list;

                if(newList.stream().filter(num -> num == jumsu).count() > count) {
                         ranking = newList.stream().filter(num -> num == jumsu).findFirst()
                                        .map(a -> newList.indexOf(a)).get() + 1;
                }                     
        }
        System.out.print(ranking);
    }
}