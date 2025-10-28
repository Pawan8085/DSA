package TREES.Problems;

public class Depth {
    
    public int maxDepth(TreeNode root) {
        
        // base case
        if(root == null) return 0;

        // make recursive call for the left & right sub stree
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        // return the maximum depth max(l, r) + 1
        return Math.max(l, r)+1;
    }
}
