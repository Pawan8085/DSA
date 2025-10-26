package TREES.Problems;

public class LCA {
    

     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

       // base case 
       if(root==null) return null;

       // return the node if it is equal to p or q 
       if(root.val==p.val || root.val==q.val) return root;

       // make recursive calls in left and right subtree
       TreeNode left = lowestCommonAncestor(root.left, p, q);
       TreeNode right = lowestCommonAncestor(root.right, p, q);

       // if left and right are not null means current node is LCA 
       if(left!=null && right!=null) return root;

       // return null if both are null or node that is not null
       return left==null ? right : left;

    }
}
