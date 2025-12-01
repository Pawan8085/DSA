import javax.swing.tree.TreeNode;

public class TrimBST {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        // base case
        if (root == null)
            return null;

        // Trim left and right subtrees
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        // If current node is smaller than low, all nodes in its left subtree are also <
        // low
        if (root.val < low) {
            return root.right;
        }

        // If current node is greater than high, all nodes in its right subtree are also
        // > high
        if (root.val > high) {
            return root.left;
        }

        // Node is within [low, high], keep it
        return root;
    }
}
