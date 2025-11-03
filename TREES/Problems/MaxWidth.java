package TREES.Problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxWidth {
    
    public int widthOfBinaryTree(TreeNode root) {
        
        Deque<Pair> dq = new ArrayDeque<>();
        dq.add(new Pair(0, root));

        int maxWidth = 0;
        while(!dq.isEmpty()){

            // get the first and last inded
            long firstIdx = dq.peekFirst().idx;
            long lastIdx = dq.peekLast().idx;

            // calculate max width
            maxWidth = Math.max(maxWidth, (int)(lastIdx-firstIdx+1));

            int size = dq.size();
            while(size-->0){

                Pair p = dq.remove();
                long idx = p.idx;
                TreeNode node = p.node;

                if(node.left != null){
                    dq.add(new Pair(2*idx+1, node.left));
                }
                if(node.right != null){
                    dq.add(new Pair(2*idx+2, node.right));
                }
            }
        }

        return maxWidth;
    }
}
class Pair{
    long idx;
    TreeNode node;
    Pair(long idx, TreeNode node){

        this.idx = idx;
        this.node = node;
    }
}
