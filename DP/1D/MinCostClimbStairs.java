public class MinCostClimbStairs {
    
    int minCost(int i, int[] cost, int[] dp){
        // base case
        if(i >= cost.length) return 0;
        
        if(dp[i] != -1) return dp[i];
        int op1 = minCost(i+1, cost, dp) ;
        int op2 = minCost(i+2, cost, dp);

        return dp[i] = Math.min(op1, op2) + cost[i]; // add cost
    }
}
