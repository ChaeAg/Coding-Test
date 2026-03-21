class Solution {
    int[] topping;
    int toppingCnt;
    int minCha = Integer.MAX_VALUE;
    int result = Integer.MAX_VALUE;
    int target;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        topping = toppingCosts;
        toppingCnt = toppingCosts.length;
        this.target = target;

        for(int base : baseCosts) {
            if(base > target) {
                if(minCha > base - target) {
                    minCha = base - target;
                    result = base;
                } else if(minCha == base - target) {
                    result = Math.min(base, result);
                }
            }
            else if(base == target) {
                result = base;
                break;
            } else {
                dfs(0, base);
            }
        }

        return result;
    }

    void dfs(int depth, int cost) {
        if(cost < target) {
            if(minCha >= target - cost) {
                if(minCha == target - cost) {
                    result = Math.min(result, cost);
                } else {
                    result = cost;
                }
                minCha = target - cost;
            }
        } else {
            if(minCha >= cost - target) {
                if(minCha == cost - target) {
                    result = Math.min(result, cost);
                } else {
                    result = cost;
                }
                minCha = cost - target;
            }
            return;
        }

        if(depth >= toppingCnt) {
            return;
        }

        dfs(depth+1, cost);
        dfs(depth+1, cost + topping[depth]);
        dfs(depth+1, cost + topping[depth] * 2);
    }
}