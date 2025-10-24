import java.util.ArrayList;
import java.util.List;

public class Postorder {
    
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();

        postorderTraversal(root, result);
        return result;
       
        
    }

    void postorderTraversal(TreeNode root, List<Integer> list){

        if(root == null) return; 
        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.val);


    }
}
