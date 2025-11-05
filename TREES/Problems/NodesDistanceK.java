package TREES.Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class NodesDistanceK {
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {


        Map<TreeNode, TreeNode> parent = new HashMap<>();

        // Map each node to its parent
        addParent(root, parent);

        Queue<TreeNode> q = new LinkedList<>();

        // keep track of visited node using vis set
        Set<TreeNode> vis = new HashSet<>();

        //Start BFS from target
        q.add(target);
        vis.add(target);

        while(!q.isEmpty() && k>0){

            int size = q.size();
            while(size-->0){

                TreeNode node = q.remove();

                if(node.left != null && !vis.contains(node.left)){
                    q.add(node.left);
                    vis.add(node.left);
                }

                if(node.right != null && !vis.contains(node.right)){
                    q.add(node.right);
                    vis.add(node.right);
                }

                if(parent.containsKey(node) && !vis.contains(parent.get(node))){
                    q.add(parent.get(node));
                    vis.add(parent.get(node));
                }
            }

            k--;
        }

        // add nodes in result array that are at distance k
         List<Integer> res = new ArrayList<>();
         while(!q.isEmpty()){
            res.add(q.remove().val);
         }

         return res;

        
    }

    // map parent node
    void addParent(TreeNode root, Map<TreeNode, TreeNode> parent){

        if(root == null) return ;

        if(root.left != null){
            parent.put(root.left, root);
        }

        if(root.right != null){
            parent.put(root.right, root);
        }


        addParent(root.left, parent);
        addParent(root.right, parent);
    }
}
