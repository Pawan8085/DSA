package DP.dp on string;

public class InterleavingString {
    // LC 97
    
    public boolean isInterleave(String s1, String s2, String s3) {

        int n = s1.length(), m = s2.length();
        if(n + m != s3.length()) return false;

        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return isInterleave(0, 0, s1, s2, s3, dp);
    }

    boolean isInterleave(int i, int j, String s1, String s2, String s3, int[][] dp){


       int k = i+j;
        if(k == s3.length()) return true;
        if(dp[i][j] != -1) return dp[i][j]==1;

        boolean res = false;
        if(i<s1.length() && s1.charAt(i) == s3.charAt(k)){
            res = res || isInterleave(i+1, j, s1, s2, s3, dp);
        }

        if(j<s2.length() && s2.charAt(j) == s3.charAt(k)){
            res = res || isInterleave(i, j+1, s1, s2, s3, dp);
        }

         dp[i][j] = res ? 1 : 0;
         return res;
    }
}
