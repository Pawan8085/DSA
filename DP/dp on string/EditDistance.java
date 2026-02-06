package DP.dp on string;

public class EditDistance {
    
     public int minDistance(String word1, String word2) {
        
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] row : dp) Arrays.fill(row, -1);
        return minDistance(0, 0, word1, word2, dp);
    }

     public int minDistance(int i, int j, String word1, String word2, int[][] dp) {
        
        if(i == word1.length()) return word2.length() - j;
        if(j == word2.length()) return word1.length() - i;

        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)){
            return dp[i][j] = minDistance(i+1, j+1, word1, word2, dp);
        }else{

            int op1 = minDistance(i, j+1, word1, word2, dp); // insert
            int op2 = minDistance(i+1, j, word1, word2, dp); // delete
            int op3 = minDistance(i+1, j+1, word1, word2, dp); // replace


            return dp[i][j] = Math.min(op1, Math.min(op2, op3)) + 1;
        }
    }
    
}
