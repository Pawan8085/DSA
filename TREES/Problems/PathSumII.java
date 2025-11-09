package TREES.Problems;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> res = new ArrayList<>();
        pathSum(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    void pathSum(TreeNode root, int target, List<Integer> cur, List<List<Integer>> res){

        // base case 
        if(root == null){
            return ;
        }

        cur.add(root.val);
        if(root.left==null && root.right==null && target-root.val == 0){
            res.add(new ArrayList<>(cur));
        }

        pathSum(root.left, target-root.val, cur, res);
        pathSum(root.right, target-root.val, cur, res);

        // backtrack
        cur.remove(cur.size()-1);
    }
}
