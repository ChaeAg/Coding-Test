// import java.util.*;
// class Solution {
//     public int solution(String s) {
//         List<String> list = List.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
//         String result = "";
//         String word = "";
//         for(String str : s.split("")) {
//             if(str.matches("[-+]?\\d*\\.?\\d+")) {
//                 result += Integer.parseInt(str);
//             }
//             else {
//                word += str;
//             }
//             if(list.contains(word)) {
//                  result += list.indexOf(word);
//                  word = "";
//             }
//         }
//         return Integer.parseInt(result);
//     }
// }


class Solution {
    public int solution(String s) {
        String result = "";
        String[] arr = s.split("");
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i].equals("z")) {
                result += "0";
                i += 3;
            }
            else if(arr[i].equals("o")) {
                result += "1";
                i += 2;
            }
            else if(arr[i].equals("t")) {
                if(arr[i+1].equals("w")) {
                    result += "2";
                    i += 2;
                }
                else {
                    result += "3";
                    i += 4;
                }
            }
            else if(arr[i].equals("f")) {
                if(arr[i+1].equals("o")) {
                    result += "4";
                    i += 3;
                }
                else {
                    result += "5";
                    i += 3;
                }
            }
            else if(arr[i].equals("s")) {
                if(arr[i+1].equals("i")) {
                    result += "6";
                    i += 2;
                }
                else {
                    result += "7";
                    i += 4;
                }
            }
            else if(arr[i].equals("e")) {
                result += "8";
                i += 4;
            }
            else if(arr[i].equals("n")) {
                result += "9";
                i += 3;
            }
            else { // 숫자인경우
                result += arr[i];
            }
        }
        
        return Integer.parseInt(result);
    }
}