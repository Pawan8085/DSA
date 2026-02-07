package DP.dp on string;

public class ValidParenthesis {
    
    public boolean checkValidString(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] row : dp) Arrays.fill(row, -1);
        return isValid(0, s, 0, dp);
    }

    boolean isValid(int i, String s, int open, int[][] dp){

        if(i==s.length()) return open==0;
        if(open < 0) return false; // negative case

        if(dp[i][open] != -1) return dp[i][open]==1;

        char ch = s.charAt(i);
        if(ch=='(' || ch==')'){
            if(ch == '('){
                boolean res = isValid(i+1, s, open+1, dp);
                dp[i][open]  = res ? 1 : 0;
                return res;
            }else{
                boolean res = isValid(i+1, s, open-1, dp);
                dp[i][open]  = res ? 1 : 0;
                return res;
            }
            
        }else{

            // * case
            boolean op1 = isValid(i+1, s, open, dp); // treat as "" string
            boolean op2 = isValid(i+1, s, open+1, dp); // treat as "(" string
            boolean op3 = isValid(i+1, s, open-1, dp); // treat as ")" string

            boolean res =  op1 || op2 || op3;
            dp[i][open]  = res ? 1 : 0;
            return res;
        }

    }
}
