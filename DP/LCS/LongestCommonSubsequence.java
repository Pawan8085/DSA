package DP.LCS;

public class LongestCommonSubsequence {
    
    public int longestCommonSubsequence(String text1, String text2) {
        // tabulation
        int n = text1.length(), m=text2.length();
        int[][] dp = new int[n+1][m+1];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                if(text1.charAt(i) == text2.charAt(j)){

                    dp[i][j] = (i-1>=0  && j-1>=0 ? dp[i-1][j-1]: 0) + 1;
                }else{

                    int op1 = i-1>=0 ? dp[i-1][j]  : 0;
                    int op2 = j-1>=0 ? dp[i][j-1] : 0;
                    dp[i][j] = Math.max(op1, op2);
                }
            }
        }

        return dp[n-1][m-1];
    }


    // memoization
    int lcs(int i, int j, String s1, String s2, int[][] dp){

       if(i<0 || j<0) return 0;

        if(dp[i][j] != -1) return dp[i][j];
       if(s1.charAt(i) == s2.charAt(j)){

            return dp[i][j] = 1 + lcs(i-1, j-1, s1, s2, dp);
       }else{

        int op1 = lcs(i-1, j, s1, s2, dp);
        int op2 = lcs(i, j-1, s1, s2, dp);

        return dp[i][j] = Math.max(op1, op2);
       }
    }
}
