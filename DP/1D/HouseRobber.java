public class HouseRobber{

    int rob(int i, int[] nums, int[] dp){

      if(i >= nums.length) return 0;
      if(dp[i] != -1) return dp[i];

      int op1 = rob(i+2, nums, dp) + nums[i]; // rob
      int op2 =  rob(i+1, nums, dp); // don't rob

      return dp[i] = Math.max(op1, op2);
        
    }
}