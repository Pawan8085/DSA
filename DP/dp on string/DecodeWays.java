package DP.dp on string;

public class DecodeWays {
    
    int ways(int i, String s, int[] dp){

      // base case
      if(i == s.length()) return 1;
      if(dp[i] != -1) return dp[i];

      char c = s.charAt(i);

      if(c != '0'){
         int count = 0;

         // call for two digits number 
         if(i+1 < s.length() && Integer.parseInt(c+""+s.charAt(i+1)) <= 26){
            count += ways(i+2, s, dp);
         }
          // call for 1 digit number   
         count += ways(i+1, s, dp);
         return dp[i] = count;
      }else{
        return dp[i] = 0;
      }

    }
}
