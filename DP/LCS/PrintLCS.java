package DP.LCS;
public class PrintLCS {
    
     public static String findLCS(int n, int m, String s, String t){
      
		int[][] dp = new int[n][m];
        

		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				if(s.charAt(i) == t.charAt(j)){
                    
					dp[i][j] = 1 +(i-1>=0 && j-1>=0 ? dp[i-1][j-1] : 0);
				}else{
				
					dp[i][j] = Math.max(i-1>=0 ? dp[i-1][j] : 0, j-1>=0 ? dp[i][j-1] : 0);
				}
			}
		}

	   StringBuilder res = new StringBuilder();	
	   int i=n-1, j=m-1;
	   while(i >=0 && j>=0){

		   if(s.charAt(i) == t.charAt(j)){
			   res.append(s.charAt(i));
			   i--;
			   j--;
		   }else{

			   int op1 = i-1>=0 ? dp[i-1][j] : 0;
			   int op2 = j-1>=0 ? dp[i][j-1] : 0;
			   if(op1 >= op2){
				   i--;
			   }else{
				   j--;
			   }
		   }
	   }		

       return res.reverse().toString();

    }
}
