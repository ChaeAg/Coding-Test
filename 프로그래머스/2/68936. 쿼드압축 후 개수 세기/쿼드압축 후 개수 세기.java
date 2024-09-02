class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2]; // 0 또는 1의 값

        int size = arr.length;
        int r = size;
        int temp = size;
        int count = 0;

        while(temp > 1) {
            temp /= 2;
            count++;
        }

        for(int c = 0; c<count; c++) {
            for(int i=0; i<size; i+=r) {
                for(int j=0; j<size; j+=r) {
                    boolean isSame = true;
                    int before = -1;
                    for(int ci=0; ci<r; ci++) {
                        for(int cj=0; cj<r; cj++) {
                            if(ci == 0 && cj == 0) {
                                before = arr[i+ci][j+cj];
                                continue;
                            }
                            if(arr[i+ci][j+cj] != before || (arr[i+ci][j+cj] != 0 && arr[i+ci][j+cj] != 1)) {
                                isSame = false;
                                break;
                            }
                            before = arr[i+ci][j+cj];
                        }
                        if(!isSame) break;
                    }
                    if(isSame) {
                        for(int ci=0; ci<r; ci++) {
                            for(int cj=0; cj<r; cj++) {
                                arr[i+ci][j+cj] = before + 2;
                            }
                        }
                        answer[before]++;
                    }
                }
            }
            r /= 2;
        }

        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(arr[i][j] == 0) {
                    answer[0]++;
                }
                else if(arr[i][j] == 1) {
                    answer[1]++;
                }
            }
        }
        
        return answer;
    }
}