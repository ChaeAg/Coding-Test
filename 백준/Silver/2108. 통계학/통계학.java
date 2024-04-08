import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        List<Integer> max_count_nums = new ArrayList<>();
        Map<Integer, Integer> counts = new HashMap<>();
        double sum = 0;
        int max = -4000, min = 4000, max_count = 0;
        
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
            max = max < nums[i] ? nums[i] : max;
            min = min > nums[i] ? nums[i] : min;
            int count = counts.getOrDefault(nums[i], 0) + 1;
            if (max_count <= count) {
                if(max_count < count) {
                    max_count_nums.clear();
                    max_count = count;
                }
                max_count_nums.add(nums[i]);
            }
            counts.put(nums[i], count);
        }
        
        System.out.println((int)(Math.round(sum / (double)N))); // 산술평균

        Arrays.sort(nums);
        System.out.println(nums[N/2]); // 중앙값

        int mode;
        if(max_count_nums.size() == 1) mode = max_count_nums.get(0);
        else {
            max_count_nums.sort(Comparator.naturalOrder());
            mode = max_count_nums.get(1);
        }
        System.out.println(mode); // 최빈값
        
        System.out.print(max-min); // 범위
    }
}