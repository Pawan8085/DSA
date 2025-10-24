import java.util.ArrayList;
import java.util.List;

public class Preorder {
    
     public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
    
        preorderTraversal(root, result);
        return result;
        
    }

    void preorderTraversal(TreeNode root, List<Integer> list){

        if(root == null) return ;

        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }
}
