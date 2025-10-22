import java.util.HashMap;
import java.util.Map;

class Preorder_Inorder{
    // Construct Binary Tree from Preorder and Inorder Traversal

     public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        // Map each value to its index in the inorder traversal for O(1) lookups
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int n = preorder.length;
        return buildTree(0, n - 1, 0, n - 1, preorder, map);
    }

    TreeNode buildTree(int is, int ie, int ps, int pe, int[] preorder, Map<Integer, Integer> map) {
        
        // If there are no nodes to process in this subtree
        if (ps > pe) return null;

        // The first element of the current preorder segment is the root value
        int val = preorder[ps];

        // Create the root node
        TreeNode node = new TreeNode(val);

        // Get the index of the root value in the inorder traversal
        int idx = map.get(val);

        // Number of nodes in the left subtree
        int numsLeft = idx - is;

        // Recursively build the left subtree
        node.left = buildTree(is, is + numsLeft, ps+1, ps + numsLeft, preorder, map);
        

        // Recursively build the right subtree
        node.right = buildTree(idx + 1, ie, ps + numsLeft+1, pe, preorder, map);

        // Return the root of the subtree
        return node;
    }
}