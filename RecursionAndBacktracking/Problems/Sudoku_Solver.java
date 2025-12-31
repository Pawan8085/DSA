package RecursionAndBacktracking.Problems;

public class Sudoku_Solver {
    
    public void solveSudoku(char[][] board) {
        // total cells = 81
        // time O(9^N) -> 9 ^ 81
         sudoku(board);
    }

    boolean sudoku(char[][] board){


        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    for(char num='1'; num<='9'; num++){
                        
                        if(isValid(i, j, board, num)){
                            board[i][j] = num;
                            if(sudoku(board)) return true;
                            board[i][j] = '.'; // backtrack
                        }
                    }
                    return false;
                }
            }
        }

        return true;
       
    }
    boolean isValid(int row, int col, char[][] board, char num){
        
        // check row 
        for(int j=0; j<9; ++j){
            if(board[row][j]==num) return false;
        }

        // check column
        for(int i=0; i<9; ++i){
            if(board[i][col]==num) return false;
        }

        // check 3*3
        int rowStart = 3 * (row/3);
        int colStart = 3 * (col/3);

        for(int i=0; i<3; ++i){
            for(int j=0; j<3; ++j){
                if(board[rowStart+i][colStart+j]==num) return false;
            }
        }
        return true;
    }
}
