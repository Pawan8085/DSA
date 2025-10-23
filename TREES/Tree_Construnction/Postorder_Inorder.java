import java.util.HashMap;
import java.util.Map;

public class Postorder_Inorder {
      // Construct Binary Tree from Inorder and Postorder Traversal
      public TreeNode buildTree(int[] inorder, int[] postorder) {

        // Map each value to its index in the inorder traversal for O(1) lookups
         Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        int n = postorder.length;
        return buildTree(0, n-1, postorder, 0, n-1, map);
        
    }


    TreeNode buildTree(int postStart, int postEnd, int[] postorder, int inStart, int inEnd, Map<Integer, Integer> map){

       // If there are no nodes to process return null
       if(postStart > postEnd) return null;

       // The last element of the current postorder traversal is root 
       int val = postorder[postEnd];

       // Create the root node 
       TreeNode node = new TreeNode(val);

        // Get the index of the root value in the inorder traversal 
       int idx = map.get(val);

        // Number of nodes in the left subtree 
       int numsLeft = idx-inStart;

       // Recursively build the left subtree 
       node.left = buildTree(postStart, postStart+numsLeft-1, postorder, inStart, inStart+numsLeft, map);

       // Recursively build the right subtree
       node.right = buildTree(postStart+numsLeft, postEnd-1, postorder, idx+1, inEnd, map);

       // Return the root of the subtree 
       return node;
    }
}
