package RecursionAndBacktracking.Problems;

public class WordSearch {
    
     public boolean exist(char[][] board, String word) {
        // time O(n∗m∗4 ^ L) where 'L' is length of word
        for(int i=0; i<board.length; ++i){
            for(int j=0; j<board[0].length; ++j){

                if(board[i][j]==word.charAt(0) && exist(0, i, j, word, board)) return true;
            }
        }
        return false;
    }

    boolean exist(int idx, int i, int j, String word, char[][] board){

      if(idx==word.length()) return true;

      int n=board.length, m=board[0].length;
      if(i<0 || i==n || j<0 || j==m || board[i][j] != word.charAt(idx)){
        return false;
      }

      
      char c = board[i][j];
      board[i][j] = '@';

      boolean op1 = exist(idx+1, i+1, j, word, board);
      boolean op2 = exist(idx+1, i-1, j, word, board);
      boolean op3 = exist(idx+1, i, j+1, word, board);
      boolean op4 = exist(idx+1, i, j-1, word, board);
      board[i][j] = c; // backtrack

      return op1 || op2 || op3 || op4;

    }
}
