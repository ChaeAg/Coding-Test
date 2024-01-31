import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = br.readLine();
        String[] nums = X.split("");

        permutation(nums, 0, nums.length);
        Collections.sort(list);
        String result = "0";

        for(int i=0; i<list.size(); i++) {
            if(Integer.parseInt(list.get(i)) > Integer.parseInt(X)) {
                result = list.get(i);
                break;
            }
        }

        System.out.print(result);
    }

    static void permutation(String[] nums, int depth, int len) {
        list.add(String.join("", nums));
        if (depth == len) return;

        for (int i=depth; i<len; i++) {
            swap(nums, depth, i);
            permutation(nums, depth + 1, len);
            swap(nums, depth, i);
        }
    }

    static void swap(String[] nums, int depth, int i) {
        String temp = nums[depth];
        nums[depth] = nums[i];
        nums[i] = temp;
    }
}