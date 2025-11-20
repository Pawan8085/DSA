package BST.Problems;

public class InsertInBST {
    
    public TreeNode insertIntoBST(TreeNode root, int val) {
        

        TreeNode newNode = new TreeNode(val);
        if(root == null) return newNode;

        TreeNode cur = root;

        while(cur != null){

            if(cur.val < val){

                if(cur.right == null){
                    // add new node
                    cur.right = newNode;
                    break;
                }

                cur = cur.right;
            }else{

                if(cur.left == null){
                    // add new node
                    cur.left = newNode;
                    break;
                }

                cur = cur.left;
            }
        }

        return root;
    }
    
}
