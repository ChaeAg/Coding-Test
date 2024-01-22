import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int idx = 1;
        char[] arr = dartResult.toCharArray();
        int[] result = new int[3];
        int round = 0;
        int num;
        if(arr[1] >= 48 && arr[1] <= 57) {
            num = 10;
            idx++;
        }
        else num = arr[0] - '0';
        
        while(round < 3 && idx < arr.length) {
            if(arr[idx] == 'S') {
                result[round] = num;
            }
            else if(arr[idx] == 'D') {
                result[round] = num * num;
            }
            else if(arr[idx] == 'T') {
                result[round] = num * num * num;
            }
            else if(arr[idx] == '*') {
                if(round == 0) {
                    result[round] *= 2;
                }
                else {
                    result[round] *= 2;
                    result[round-1] *= 2;
                }
            }
            else if(arr[idx] == '#') {
                result[round] *= -1;
            }
            else {
                if(arr[idx-1] >= 48 && arr[idx-1] <= 57) {
                    num = 10;
                    round++;
                }
                else if(arr[idx+1] < 48 || arr[idx+1] > 57) {
                    num = arr[idx] - '0';
                    round++;
                }
            }
            idx++;
        }
        
        return Arrays.stream(result).sum();
    }
}