package TREES.Problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TimeNeededToInfectTree {
    
     public int amountOfTime(TreeNode root, int start) {

       // Get the starting node 
       TreeNode startNode = getNode(root, start);

       // Map each node to its parent
       Map<TreeNode, TreeNode> parent = new HashMap<>();
       addParent(root, parent);

       // Start BFS from starting node
       Set<TreeNode> vis = new HashSet<>();
       Queue<TreeNode> q = new LinkedList<>();
       q.add(startNode);
       vis.add(startNode);


       int time = 0;

       while(!q.isEmpty()){

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
            time++;
       }
       return time-1;


    }

    // map parent node
    void addParent(TreeNode root, Map<TreeNode, TreeNode> map){

        if(root == null){
            return ;
        }

        if(root.left != null){
            map.put(root.left, root);
        }

        if(root.right != null){
            map.put(root.right, root);
        }

        addParent(root.left, map);
        addParent(root.right, map);
    }

    // get the starting node
    TreeNode getNode(TreeNode root, int val){

        if(root == null) return null;

        if(root.val == val) return root;

        TreeNode left = getNode(root.left, val);
        if(left != null) return left;

        TreeNode right = getNode(root.right, val);
        if(right != null) return right;
        return null;

    }
}
