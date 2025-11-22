package BST.Problems;

public class SortedArrayToBST {
    
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return buildBST(0, nums.length-1, nums);
    }

    public TreeNode buildBST(int l, int r, int[] nums){
     // base case    
     if(l > r) return null;

     int mid = l + (r - l) / 2;
     
     // create tree node
     TreeNode node = new TreeNode(nums[mid]);
     
     // recursively create left & right subtree
     node.left = buildBST(l, mid-1, nums);
     node.right = buildBST(mid+1, r, nums);

     return node;
    }
}
