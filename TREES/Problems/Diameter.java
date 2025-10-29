package TREES.Problems;

public class Diameter {

    public int diameterOfBinaryTree(TreeNode root) {
        int[] d = new int[]{0};
        depth(root, d);
        return d[0];
    }


    int depth(TreeNode root, int[] d){

        if(root == null) return 0;

        int l = depth(root.left, d);
        int r = depth(root.right, d);

        // calculate diameter
        d[0] = Math.max(d[0], l+r);
        return Math.max(l, r)+1;
    }
    
}
