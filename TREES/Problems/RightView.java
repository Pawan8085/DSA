package TREES.Problems;

import java.util.ArrayList;
import java.util.List;

public class RightView {
    
     public List<Integer> rightSideView(TreeNode root) {

      List<Integer> res = new ArrayList<>();
      if(root == null){
        return res;
      }

        rightSideView(root, 0, res);
        return res;
    }

    void rightSideView(TreeNode root, int level, List<Integer> res){
     // base case 
     if(root==null) return;

     // store right view for each level
     if(level==res.size()){
        res.add(root.val);
     }

     // make recursive calls
     rightSideView(root.right, level+1, res);
     rightSideView(root.left, level+1, res);
    }
}
