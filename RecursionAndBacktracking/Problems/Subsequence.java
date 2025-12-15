package RecursionAndBacktracking.Problems;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {
    
     public  List<List<Integer>> subsets(int[] nums) {

        // time : O(N * 2^N)
        // space : O(N * 2^N)
        List<List<Integer>> res = new ArrayList<>();
        subsets(0, nums, new ArrayList<>(), res);
        
        return res;

    }

    void subsets(int i, int[] nums, List<Integer> cur, List<List<Integer>> res){

      if(i==nums.length){
        res.add(new ArrayList<>(cur));
        return ;
      }

      cur.add(nums[i]);
      subsets(i+1, nums, cur, res); // take

      cur.remove(cur.size()-1); // backtrack
      subsets(i+1, nums, cur, res); // don't take



    }

    
}
