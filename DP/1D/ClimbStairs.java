public class ClimbStairs {
    
    int climbStairs(int n, int[] dp){

        if(n == 0) return 1;
        if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];
        
        int op1 = steps(n-1, dp);
        int op2 = steps(n-2, dp);

        return dp[n] = op1 + op2;
    }
}
