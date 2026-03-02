class Solution {
     public int solution(String[] arr) {
        int totalMin = 0;
        int totalMax = 0;
        int sum = 0;

        // 왼쪽 <- 오른쪽 방향으로 스캔
        for (int i = arr.length - 1; i >= 0; i--) {
            // 숫자면 더하기
            char c = arr[i].charAt(0);
            if (c >= '0' && c <= '9') {
                sum += Integer.parseInt(arr[i]);
                continue;
            }

            // '-'에서만 상태 갱신
            if (c == '-') {
                int tempMin = totalMin;
                int tempMax = totalMax;

                // '-' 바로 오른쪽 숫자
                int nextNumber = Integer.parseInt(arr[i + 1]);

                // ... "-"1+2+3 + (min/max) 이었다면
                // totalMin = (max와 sum 다 반전) or min에 sum을 빼줌
                // totalMax = (min과 sum을 반전 = 값이 최대한 높아지도록) or (max와 sum을 더하고 맨 앞 숫자만 빼줌(여기선 -1))
                totalMin = Math.min(-(tempMax + sum), tempMin - sum);
                totalMax = Math.max(-(tempMin + sum), tempMax + sum - 2 * nextNumber);

                sum = 0;
            }
        }

        // 맨 앞쪽에 남은 합 더해주기
        totalMax += sum;
        return totalMax;
    }
}