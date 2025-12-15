package RecursionAndBacktracking.Problems;

import java.util.Arrays;

public class Permutations {
    
     void permutations(int i, int[] nums){

        if(i == nums.length){

            System.out.println(Arrays.toString(nums));
            return ;
        }


       for(int j=i; j<nums.length; j++){
         swap(i, j, nums);
         permutations(i+1, nums);
         swap(i, j, nums);
       }
    }

    void swap(int i, int j, int[] nums){

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
