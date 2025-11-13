package TREES.Problems;

public class MaximumPathSum {
    
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        maxSum(root);
        return max;
    }



    int maxSum(TreeNode root){
       // base case
       if(root == null) return 0;


       int l = maxSum(root.left);
       int r = maxSum(root.right);


       // there is no meaning of including negative value in current node value
       l = l<0 ? 0 : l;
       r = r<0 ? 0 : r;

      // update result
       int max_sum = Math.max(l+r+root.val, Math.max(root.val+l, root.val+r));
       max = Math.max(max, max_sum);

       // return maximum path 
       return Math.max(l, r) + root.val;
        
    }
}
