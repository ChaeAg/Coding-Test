class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = 0, attackIdx = 0, gauge = 0, maxHealth = health;
        
        while(time <= attacks[attacks.length-1][0]) {
            // 몬스터가 공격할 때
            if(attacks[attackIdx][0] == time) {
                health -= attacks[attackIdx++][1];
                gauge = 0;
                if(health <= 0) {
                    return -1;
                }
            }
            else { // 몬스터가 공격 안 할 때
                gauge++;
                health += bandage[1];
                if(gauge % bandage[0] == 0) {
                    health += bandage[2];
                    gauge = 0;
                }
                if(health > maxHealth) {
                    health = maxHealth;
                }
            }
            time++;
        }
        
        return health;
    }
}