public class BST_Iterator {
    
    Stack<TreeNode> stk ;

    public BSTIterator(TreeNode root) {
        stk = new Stack<>();
        addLeftNodes(root);
    }
    
    public int next() {
        
        TreeNode top = stk.pop();
        addLeftNodes(top.right);
        return top.val;
    }
    
    public boolean hasNext() {
        return !stk.isEmpty();
    }

    void addLeftNodes(TreeNode node){

        while(node != null){
            stk.push(node);
            node = node.left;
        }
    }
}
