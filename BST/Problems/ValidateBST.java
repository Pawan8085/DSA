import javax.swing.tree.TreeNode;

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null)
            return true;

        // node must be strictly between min and max
        if (node.val <= min || node.val >= max)
            return false;

        // left subtree must be in (min, node.val)
        // right subtree must be in (node.val, max)
        boolean left = isValidBST(node.left, min, node.val);
        boolean right = isValidBST(node.right, node.val, max);

        return left && right;
    }
}
