import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        if(k >= enemy.length) return enemy.length;

        Queue<Integer> que = new PriorityQueue<>((o1, o2) -> {
            return o1 - o2;
        });
        
        int round = 0;
        for(int i=0; i<enemy.length; i++) {
            if(que.size() >= k) { // 무적권을 다썼을 때
                int num = que.poll();//지나온 라운드중 한 라운드에 가장 적었던 적의 수
                
                if(num < enemy[i]) { // 현재 적이 더 많음. (무적권 지금 쓰는게 이득)
                    if(n < num) { // 가장 적었던 적의 수가 현재 싸울 수 있는 병사의 수보다 많으면 이거 대신 지금 라운드에 무적권을 써도 이번 라운드 못이김.
                        round = i;
                        break;
                    }
                    que.add(enemy[i]); // 이번 라운드까지 이김
                    n -= num; // 이 지나온 라운드는 병사를 소모해서 싸운 셈
                } else {
                    if(n < enemy[i]) { // 현재 적이 지나온 라운드 중에 젤 적은데 이번 라운드 못이김.
                        round = i;
                        break;
                    }
                    
                    que.add(num);
                    n -= enemy[i]; // 이번 라운드 병사 써서 이김
                }
            } else {
                que.add(enemy[i]); // 일단 개수가 남았으니 무적권을 쓴다고 가정
            }
            round++;
        }
        
        return round;
    }
}