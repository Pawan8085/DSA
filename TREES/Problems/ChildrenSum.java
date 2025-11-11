package TREES.Problems;

import org.w3c.dom.Node;

public class ChildrenSum {
    
    public boolean isSumProperty(Node root) {
        // base case
        if(root == null) return true;
        
        // leaf node already follows children sum property
        if(root.left == null && root.right==null) return true;
        
        int l = root.left != null ? root.left.data : 0;
        int r = root.right != null ? root.right.data : 0;
        
        
        if(l + r != root.data) return false;
        
        
        return isSumProperty(root.left) && isSumProperty(root.right);
    }
}
