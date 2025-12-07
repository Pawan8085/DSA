import javax.swing.tree.TreeNode;

public class TwoSumInBST {
    
    public boolean findTarget(TreeNode root, int k) {

        if(root == null) return false;

        BstIterator bi1 = new BstIterator(root, true);
        BstIterator bi2 = new BstIterator(root, false);

        int l = bi1.next();
        int r = bi2.next();

        while(l < r){

            if(l+r == k) return true;
            else if(l+r > k) r = bi2.next();
            else l = bi1.next();
        }

        return false;

    }
}

class BstIterator{

    boolean left;
    Stack<TreeNode> stk ;

    public BstIterator(TreeNode node, boolean left){
        stk = new Stack<>();
        this.left = left;
        pushAll(node);
    }

    int next(){
       TreeNode cur = stk.pop();
       if(left){
        pushAll(cur.right);
       }else{
        pushAll(cur.left);
       }
       return cur.val;
    }

    void pushAll(TreeNode node){

        if(left){
            while(node != null){
                stk.push(node);
                node = node.left;
            }
        }else{
            while(node != null){
                stk.push(node);
                node = node.right;
            }
        }
    }

}
