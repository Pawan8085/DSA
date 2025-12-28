package RecursionAndBacktracking.Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queen {
    
      public List<List<String>> solveNQueens(int n) {
        
        // time O(n * n!)
       char[][] board = new char[n][n];
       for(int i=0; i<n; i++){
        Arrays.fill(board[i], '.');
       } 
       List<List<String>>  res = new ArrayList<>(); 
       nQueens(0, board, res);
       return res;
    }

    void nQueens(int row, char[][] board, List<List<String>> res){

        if(row == board.length){
            res.add(gridToList(board));
            return ;
        }


        for(int col=0; col<board.length; col++){

            if(isValidPos(row, col, board)){
                board[row][col] = 'Q';
                nQueens(row+1, board, res);
                board[row][col] = '.';
            }
        }
    }

    boolean isValidPos(int i, int j, char[][] board){

        // check top left diagonal
        for(int x=i, y=j; x>=0 && y>=0; x--,y--){
            if(board[x][y] == 'Q') return false;
        }


        // check column row;
        for(int x=i; x>=0; x--){
            if(board[x][j] == 'Q') return false;
        }

        // check top right diagonal
         for(int x=i, y=j; x>=0 && y<board.length; x--,y++){
            if(board[x][y] == 'Q') return false;
        }
        return true;
    }

    List<String> gridToList(char[][] board){
        List<String> list = new ArrayList();
        for(int i=0; i<board.length; ++i){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<board.length; ++j){
                sb.append(board[i][j]);
            }
            list.add(sb.toString());
        }
        return list;
    }
}
