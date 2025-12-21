package RecursionAndBacktracking.Problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    
     public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();
        generate(0, 0, n, "", res);
        return res;
    }


    public void generate(int op, int cl, int n, String cur, List<String> res){
        // store the result
       if(cur.length() == 2*n){
        res.add(cur);
        return ;
       }

       if(op < n){
            generate(op+1, cl, n, cur+"(", res);
       }

       if(cl < op){
            generate(op, cl+1, n, cur+")", res);
       }

    }
}
