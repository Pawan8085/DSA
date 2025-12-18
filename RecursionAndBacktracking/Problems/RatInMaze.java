package RecursionAndBacktracking.Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RatInMaze {
    
    public ArrayList<String> ratInMaze(int[][] maze) {
        // time O(4^(n*m))
        ArrayList<String> res = new ArrayList<>();
        paths(0, 0, maze, "", res);
        Collections.sort(res);
        return res;
        
    }
    
    
    void paths(int i, int j, int[][] mat, String psf, List<String> res){
        
        int n = mat.length;
        int m = mat[0].length;
        // store the path
        if(i==n-1 && j==m-1){
            res.add(psf);
            return ;
        }
        
        if(i<0 || i==n || j<0 || j==m || mat[i][j]==0){
            return ;
        }
        
        mat[i][j] = 0;
        paths(i+1, j, mat, psf+"D", res);
        paths(i-1, j, mat, psf+"U", res);
        paths(i, j+1, mat, psf+"R", res);
        paths(i, j-1, mat, psf+"L", res);
        mat[i][j] = 1; // backtrack
    }
}
