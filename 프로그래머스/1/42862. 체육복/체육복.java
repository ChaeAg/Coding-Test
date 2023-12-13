import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> reserveList = Arrays.stream(reserve)
            .boxed()
            .collect(Collectors.toList());
        List<Integer> lostList =  Arrays.stream(lost)
            .boxed()
            .collect(Collectors.toList());
        List<Integer> have = new ArrayList();
        for(int i=1; i<=n; i++) {
            have.add(i);
        }
        for(int lostStudent : lost) {
            if(have.contains(lostStudent)) have.remove(have.indexOf(lostStudent));
        }
        for(int reserveStudent : reserve) {
            if(have.contains(reserveStudent)) have.remove(have.indexOf(reserveStudent));
        }
        int haveCount = have.size();
        for(int i=0; i<reserve.length; i++) { // 여벌 체육복을 가져온 학생이 도난당한 경우를 카운트
            haveCount += 1;
            if(lostList.contains(reserve[i])) {
                lostList.remove(lostList.indexOf(reserve[i]));
                reserveList.remove(reserveList.indexOf(reserve[i]));
            }
        }
        int[] lostArr = lostList.stream()
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
        
        for(int i=0; i<lostArr.length; i++) {
            if(reserveList.contains(lostArr[i]-1)) {
                haveCount += 1;
                reserveList.remove(reserveList.indexOf(lostArr[i]-1));
                continue;
            }
            if(reserveList.contains(lostArr[i]+1)) {
                haveCount += 1;
                reserveList.remove(reserveList.indexOf(lostArr[i]+1));
            }
        }
        
        return haveCount;
    }
}