package BST.Problems;

public class SearchInBST {
    
    public TreeNode searchBST(TreeNode root, int val) {
        
        TreeNode res = null;

        while(root != null){

            // If current node matches, store it and exit
            if(root.val == val){
               res = root;
               break;
            }
            // if current value is greater than target, search left subtree
            else if(root.val > val){
                root = root.left;
            }
            // if current value is samller than target, search right subtree
            else{
                root = root.right;
            }
        }


        return res;

     
    }

}
