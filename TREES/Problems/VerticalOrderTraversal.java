package TREES.Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        

        Queue<Pair> q = new LinkedList<>();
        Map<Integer, List<Integer>> map = new TreeMap();
        q.add(new Pair(root, 0));

        while(!q.isEmpty()){

            int size = q.size();
            for(int i=0; i<size; ++i){
                Pair p = q.poll();

               List<Integer> list = map.getOrDefault(p.ind, new ArrayList<>());
               list.add(p.node.val);
               map.put(p.ind, list);

                if(p.node.left != null){
                    q.add(new Pair(p.node.left, p.ind-1));
                }
                if(p.node.right != null){
                    q.add(new Pair(p.node.right, p.ind+1));
                }
            }
        }

        List<List<Integer>> result = new ArrayList();
        for(Integer key : map.keySet()){

           List<Integer> list = map.get(key);
           Collections.sort(list);
            result.add(list);
        }

        return result;
    }

}


class Pair{

    TreeNode node;
    int ind;

    public Pair(TreeNode node, int ind){
        this.node = node;
        this.ind = ind;
    }
}
