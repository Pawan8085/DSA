import java.util.ArrayList;



public class PredecessorAndSuccessor {
    
    public ArrayList<Node> findPreSuc(Node root, int key) {
        
        
        Node p = null;
        Node cur = root;
        
        while(cur != null){
            if(cur.data < key){
                p = cur;
                cur = cur.right;
            }else{
                cur = cur.left;
            }
        }
        
        cur = root;
        Node s = null;
        while(cur != null){
            if(cur.data > key){
                s = cur;
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        
        ArrayList<Node> res = new ArrayList<>();
        res.add(p);
        res.add(s);
        return res;
    }
}
