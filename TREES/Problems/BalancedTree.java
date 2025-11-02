package TREES.Problems;

public class BalancedTree {
    
     public boolean isBalanced(TreeNode root) {
        
        return dfs(root) != -1;
        
    }

    int dfs(TreeNode root){
     
     // base case
     if(root==null) return 0;
     
     // make recursive calls
     int l = dfs(root.left);
     int r = dfs(root.right);

     // if left or right subtree is unbalanced returns -1 
     if(l==-1 || r==-1) return -1;

     // if height is not balanced return -1;
     if(Math.abs(l-r) > 1) return -1;

     // return height of current subtree 
     return Math.max(l, r)+1;

       
    }
}
