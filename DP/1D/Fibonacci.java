import java.util.Arrays;

public class Fibonacci {
   

   public static void main(String[] var0) {
      byte n = 10;
      int[] dp = new int[n + 1];
      Arrays.fill(dp, -1);
      int res = fid(n, dp);
      System.out.println(res);
   }

   static int fid(int n, int[] dp) {
      // base case
      if(n <= 1) return n;

      if(dp[n] != -1) return dp[n];
      return dp[n] = fid(n-1, dp) + fid(n-2, dp);
   }
}