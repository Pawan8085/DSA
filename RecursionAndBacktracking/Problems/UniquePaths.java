package RecursionAndBacktracking.Problems;

public class UniquePaths {
    
    public int uniquePathsIII(int[][] grid) {
        int sI = -1;
        int sJ = -1;

        int zero  = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    sI = i;
                    sJ = j;
                    
                }
                if(grid[i][j] == 0) zero++;
            }
            
        }

        
        return uniquePath(sI, sJ, grid, zero);
        
    }

    int uniquePath(int i, int j, int[][] grid, int zero) {
        
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == -1) {
            return 0;
        }
        if (grid[i][j] == 2) {
            
            return zero == -1 ? 1 : 0;
        }
        zero--;
        grid[i][j] = -1;
        int total = uniquePath(i + 1, j, grid, zero) 
          + uniquePath(i - 1, j, grid, zero)
          + uniquePath(i, j + 1, grid, zero) 
          + uniquePath(i, j - 1, grid, zero);
    
        grid[i][j] = 0; 
        zero++;

        return total;
    }
}
