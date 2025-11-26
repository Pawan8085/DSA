package BST.Problems;

public class DeleteInBST {
    

     public TreeNode deleteNode(TreeNode root, int key) {
       // base case
       if(root == null) return null; 
       // delete & fix the node
       if(root.val == key) return fixTree(root.left, root.right);
       
       if(root.val > key){
        root.left = deleteNode(root.left, key);
       }else{
        root.right = deleteNode(root.right, key);
       }

       return root;

    }

    private TreeNode fixTree(TreeNode left, TreeNode right){

        if(left==null || right==null){
            return left==null ? right : left;
        }
        
        // go to the greatest node of left and connect right
        TreeNode cur = left;
        while(cur.right != null){
            cur = cur.right;
        }

        cur.right = right;
        return left;
    }
}
